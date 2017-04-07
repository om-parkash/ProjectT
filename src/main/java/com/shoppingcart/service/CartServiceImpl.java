package com.shoppingcart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.CartDao;
import com.shoppingcart.domain.Cart;
import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.dto.CartDto;
import com.shoppingcart.exception.DaoException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * The Class CartServiceImpl.
 */
@Service("CartServiceImpl")
public class CartServiceImpl implements CartService {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(CartServiceImpl.class);

	/**
	 * The cart dao.
	 */
	@Autowired
	private CartDao cartDao;

	/** The shopping item service. */
	@Autowired
	private ShoppingItemService shoppingItemService;

	@Override
	public CartDto getCartForUser(final UserMaster userMaster) throws ServiceException {
		LOGGER.info("Executing getCartforUser for usermaster " + userMaster);
		CartDto cartDto = null;
		cartDto = new CartDto();
		List<Cart> listOfCarts = null;
		try {
			listOfCarts = cartDao.findAllByUserMaster(userMaster);
		} catch (final DaoException daoException) {
			LOGGER.error("Error occurred in get cart for user for user master +" + userMaster);
			throw new ServiceException("Error occurred in getCartforUser", daoException);
		}
		setCartDtoFromCart(userMaster, cartDto, listOfCarts);
		return cartDto;
	}

	/**
	 * Sets the cart dto from cart.
	 *
	 * @param userMaster the user master
	 * @param cartDto the cart dto
	 * @param listOfCarts the list of carts
	 */
	private void setCartDtoFromCart(final UserMaster userMaster, final CartDto cartDto, final List<Cart> listOfCarts) {
		if (listOfCarts != null) {
			cartDto.setUserMaster(userMaster);
			final Map<ShoppingItem, Integer> shoppingItemWithQuantity = new LinkedHashMap<>(listOfCarts.size());
			for (final Cart cart : listOfCarts) {
				if (shoppingItemWithQuantity.containsKey(cart.getItem())) {
					shoppingItemWithQuantity.put(cart.getItem(), shoppingItemWithQuantity.get(cart.getItem()) + cart.getQuantity());
				} else {
					shoppingItemWithQuantity.put(cart.getItem(), cart.getQuantity());
				}
			}
			cartDto.setShoppingItemWithQuantity(shoppingItemWithQuantity);
		}
	}

	@Override
	public CartDto addItemToCart(final UserMaster userMaster, final Integer shoppingItemId, final Integer quantity,
			final CartDto cartDto) throws ServiceException {
		CartDto dto = cartDto;
		Integer tempQuantity = quantity;
		LOGGER.info("Executing addItemToCart for usermaster " + userMaster);
		if (dto == null) {
			LOGGER.info("Setting new cart object for usermaster " + userMaster);
			dto = new CartDto();
		}
		final ShoppingItem item = shoppingItemService.fetchItemById(shoppingItemId);

		if (dto.getShoppingItemWithQuantity().containsKey(item)) {
			tempQuantity = tempQuantity + dto.getShoppingItemWithQuantity().get(item);
			dto = updateItemQuantityInCart(userMaster, shoppingItemId, tempQuantity);
		} else {
			final Cart cart = new Cart(userMaster, item, tempQuantity);
			List<Cart> listOfCarts = null;
			try {
				cartDao.save(cart);
				listOfCarts = cartDao.findAllByUserMaster(userMaster);
			} catch (final DaoException daoException) {
				final String errorMessage = "Error occurred while saving cart object for usermaster " + userMaster + " cart is "
						+ cart + "or fetching all carts for user master";
				LOGGER.error(errorMessage);
				throw new ServiceException(errorMessage, daoException);
			}
			setCartDtoFromCart(userMaster, dto, listOfCarts);
		}
		return dto;
	}

	@Override
	public CartDto removeItemFromCart(final UserMaster userMaster, final Integer shoppingItemId) throws ServiceException {
		LOGGER.info("Executing removeItemFromCart for usermaster " + userMaster);
		final ShoppingItem item = shoppingItemService.fetchItemById(shoppingItemId);
		try {
			cartDao.deleteByUserMasterAndItem(userMaster, item);
		} catch (final DaoException daoException) {
			LOGGER.error("Error occurred while removing item from cart for user master" + userMaster + " and item is " + item);
			throw new ServiceException("Error occurred while removing item from cart", daoException);
		}
		LOGGER.info("Successfully executed removeItemFromCart for usermaster " + userMaster);
		return getCartForUser(userMaster);
	}

	@Override
	public CartDto updateItemQuantityInCart(final UserMaster userMaster, final Integer itemId, final Integer quantity)
			throws ServiceException {
		LOGGER.info("Executing updateItemQuantityInCart for usermaster " + userMaster);
		final ShoppingItem shoppingItem = shoppingItemService.fetchItemById(itemId);
		try {
			final Cart cart = cartDao.findOneByUserMasterAndItem(userMaster, shoppingItem);
			cart.setQuantity(quantity);
			cartDao.save(cart);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred in updating item quantity in cart for user master " + userMaster
					+ " , item is " + shoppingItem + " and quantity to be updated is " + quantity;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		LOGGER.info("Successfully executed updateItemQuantityInCart for usermaster " + userMaster);
		return getCartForUser(userMaster);
	}

	@Override
	public void clearCartForUser(final UserMaster userMaster) throws ServiceException {
		LOGGER.info("Executing clearCartForUser for usermaster " + userMaster);
		try {
			cartDao.deleteByUserMaster(userMaster);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while clearing cart for user master " + userMaster;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		LOGGER.info("Successfully executed clearCartForUser for usermaster " + userMaster);
	}
}
