package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.exception.ServiceException;

/**
 * Service to fetch shopping items.
 * 
 */
public interface ShoppingItemService {

	/**
	 * Returns shopping item by specified name.
	 * 
	 * @param itemName {@link String} to be fetched.
	 * @return ShoppingItem {@link ShoppingItem} matched with the specified itemName.
	 * @throws ServiceException
	 */
	ShoppingItem fetchItemByName(String itemName) throws ServiceException;

	/**
	 * Returns shopping item by specified id.
	 *
	 * @param itemId the item id
	 * @return ShoppingItem {@link ShoppingItem} matched with the specified itemName.
	 * @throws ServiceException
	 */
	ShoppingItem fetchItemById(Integer itemId) throws ServiceException;

	/**
	 * Returns all the shopping items.
	 * 
	 * @return {@link List<ShoppingItem>} of all shopping items.
	 * @throws ServiceException
	 */
	List<ShoppingItem> fetchAllItems() throws ServiceException;

}
