package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.ItemOrderMasterDAO;
import com.shoppingcart.domain.ItemOrderMaster;
import com.shoppingcart.domain.OrderItem;
import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.dto.CartDto;
import com.shoppingcart.dto.OrderDto;
import com.shoppingcart.exception.DaoException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * Implementation of {@link ShoppingItemService}.
 */
@Service("ItemOrderMasterService")
public class ItemOrderMasterServiceImpl implements ItemOrderMasterService {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(ItemOrderMasterServiceImpl.class);

	/**
	 * ShoppingItemDAO autowired.
	 */
	@Autowired
	private ItemOrderMasterDAO itemOrderMasterDAO;

	/** The shopping item service. */
	@Autowired
	private ShoppingItemService shoppingItemService;

	/** The cart service. */
	@Autowired
	private CartService cartService;

	public OrderDto processOrder(final UserMaster userMaster, final Integer itemId, final Integer quantity) throws ServiceException {
		LOGGER.info("In executing processOrder for user name " + userMaster.getUserName());
		ItemOrderMaster itemOrderMaster = new ItemOrderMaster();
		itemOrderMaster.setUserMaster(userMaster);
		final ShoppingItem shoppingItem = shoppingItemService.fetchItemById(itemId);
		itemOrderMaster.setOrderAmount(shoppingItem.getItemPrice() * quantity);
		itemOrderMaster.setOrderDate(new Date());
		try {
			itemOrderMaster = itemOrderMasterDAO.save(itemOrderMaster);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while saving item order master " + itemOrderMaster;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return new OrderDto(itemOrderMaster.getOrderId(), itemOrderMaster.getOrderAmount(), new Date());
	}

	@Override
	public List<OrderDto> fetchAllOrders(final UserMaster master) throws ServiceException {
		LOGGER.info("In fetching all orders");
		List<ItemOrderMaster> ordersListFromDao = null;
		try {
			ordersListFromDao = itemOrderMasterDAO.findByUserMaster(master);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while fetching all orders for user master " + master;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		final List<OrderDto> orderListDto = new ArrayList<>(ordersListFromDao.size());

		if (ordersListFromDao != null && !ordersListFromDao.isEmpty()) {
			for (final ItemOrderMaster orderMaster : ordersListFromDao) {
				final OrderDto orderDto = new OrderDto();
				convertOrderDaoToDto(orderMaster, orderDto);
				orderListDto.add(orderDto);
			}
		}

		return orderListDto;
	}

	/**
	 * Convert order dao to dto.
	 *
	 * @param orderMaster the order master
	 * @param orderDto the order dto
	 */
	private void convertOrderDaoToDto(final ItemOrderMaster orderMaster, final OrderDto orderDto) {
		orderDto.setOrderId(orderMaster.getOrderId());
		orderDto.setAmount(orderMaster.getOrderAmount());
		final Map<ShoppingItem, Integer> shoppingItemsWithQuantity = orderDto.getShoppingItemsWithQuantity();

		for (final OrderItem orderItem : orderMaster.getListOfOrderItem()) {
			if (shoppingItemsWithQuantity.containsKey(orderItem.getShoppingItem())) {
				shoppingItemsWithQuantity.put(orderItem.getShoppingItem(), shoppingItemsWithQuantity.get(orderItem.getShoppingItem())
						+ orderItem.getQuantity());
			} else {
				shoppingItemsWithQuantity.put(orderItem.getShoppingItem(), orderItem.getQuantity());
			}
		}
		orderDto.setOrderDate(orderMaster.getOrderDate());
	}

	@Override
	public OrderDto processOrder(final UserMaster userMaster) throws ServiceException {

		final CartDto cartDto = cartService.getCartForUser(userMaster);

		final Map<ShoppingItem, Integer> map = cartDto.getShoppingItemWithQuantity();
		final List<OrderItem> items = new ArrayList<>();
		ItemOrderMaster itemOrderMaster = new ItemOrderMaster();
		Float price = 0.0f;
		for (final ShoppingItem item : map.keySet()) {
			price = price + item.getItemPrice() * map.get(item);
			final OrderItem orderItem = new OrderItem(item, map.get(item));
			items.add(orderItem);
		}

		itemOrderMaster.setUserMaster(userMaster);
		itemOrderMaster.setOrderAmount(price);
		itemOrderMaster.setListOfOrderItem(items);
		itemOrderMaster.setOrderDate(new Date());

		try {
			itemOrderMaster = itemOrderMasterDAO.save(itemOrderMaster);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while saving item order " + itemOrderMaster;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		cartService.clearCartForUser(userMaster);

		final OrderDto orderDto = new OrderDto();
		convertOrderDaoToDto(itemOrderMaster, orderDto);
		return orderDto;
	}
}
