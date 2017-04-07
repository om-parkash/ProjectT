package com.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.domain.ShoppingItem;

/**
 * Template to fetch shopping items from database.
 * 
 */
public interface ShoppingItemDAO extends CrudRepository<ShoppingItem, Serializable> {

	/**
	 * Returns shopping item of specified name from database.
	 * 
	 * @param itemName {@link String} to be fetched.
	 * @return {@link ShoppingItem} matched with the specified itemName.
	 */
	ShoppingItem findOneByItemName(String itemName);

	/**
	 * Returns all the shopping items from database.
	 * 
	 * @return {@link List<ShoppingItem>} of all shopping items.
	 */
	List<ShoppingItem> findAll();

	/**
	 * Returns shopping item of specified id from database.
	 * 
	 * @param itemName {@link Integer} to be fetched.
	 * @return {@link ShoppingItem} matched with the specified itemName.
	 */
	ShoppingItem findOneByItemId(Integer itemId);
}
