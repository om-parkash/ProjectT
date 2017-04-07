package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.ShoppingItemDAO;
import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.exception.DaoException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * Implementation of {@link ShoppingItemService}.
 * 
 */
@Service("ShoppingItemService")
public class ShoppingItemServiceImpl implements ShoppingItemService {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(ShoppingItemServiceImpl.class);

	/**
	 * ShoppingItemDAO autowired.
	 */
	@Autowired
	private ShoppingItemDAO shoppingItemDAO;

	/**
	 * Returns shopping item by specified name.
	 * 
	 * @param itemName {@link String} to be fetched.
	 * @return ShoppingItem {@link ShoppingItem} matched with the specified itemName.
	 * @throws ServiceException
	 */
	public ShoppingItem fetchItemByName(final String itemName) throws ServiceException {
		LOGGER.info("Executing fetchItemByName for item name :" + itemName);
		ShoppingItem item = null;
		try {
			item = shoppingItemDAO.findOneByItemName(itemName);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while finding shopping item by name " + itemName;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return item;
	}

	/**
	 * Returns all the shopping items.
	 * 
	 * @return {@link List<ShoppingItem>} of all shopping items.
	 * @throws ServiceException
	 */
	public List<ShoppingItem> fetchAllItems() throws ServiceException {
		LOGGER.info("Executing fetchAllItems.");
		List<ShoppingItem> listOfShoppingItems = null;
		try {
			listOfShoppingItems = shoppingItemDAO.findAll();
		} catch (final DaoException daoException) {
			String errorMessage = "Error occurred while finding all shopping items.";
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return listOfShoppingItems;
	}

	public ShoppingItem fetchItemById(final Integer itemId) throws ServiceException {
		LOGGER.info("Executing fetchItemById.");
		ShoppingItem shoppingitem = null;
		try {
			shoppingitem = shoppingItemDAO.findOneByItemId(itemId);
		} catch (final DaoException daoException) {
			final String errorMessage = "Error occurred while fetching item by id " + itemId;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return shoppingitem;
	}

}
