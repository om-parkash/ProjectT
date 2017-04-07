package com.shoppingcart.service;

import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.dto.CartDto;
import com.shoppingcart.exception.ServiceException;

/**
 * The Interface CartService.
 */
public interface CartService {

	/**
	 * Gets the cartfor user.
	 *
	 * @param master the master
	 * @return the cartfor user
	 * @throws ServiceException
	 */
	CartDto getCartForUser(UserMaster master) throws ServiceException;

	/**
	 * Adds the item to cart.
	 *
	 * @param userMaster the user master
	 * @param shoppingItemId the shopping item id
	 * @param quantity the quantity
	 * @param cartDto the cart dto
	 * @return the cart dto
	 * @throws ServiceException
	 */
	CartDto addItemToCart(UserMaster userMaster, Integer shoppingItemId, Integer quantity, CartDto cartDto) throws ServiceException;

	/**
	 * Removes the item from cart.
	 *
	 * @param master the master
	 * @param shoppingItemId the shopping item id
	 * @return the cart dto
	 * @throws ServiceException
	 */
	CartDto removeItemFromCart(UserMaster master, Integer shoppingItemId) throws ServiceException;

	/**
	 * Update item quantity in cart.
	 *
	 * @param userMaster the user master
	 * @param itemId the item id
	 * @param quantity the quantity
	 * @return the cart dto
	 * @throws ServiceException
	 */
	CartDto updateItemQuantityInCart(UserMaster userMaster, Integer itemId, Integer quantity) throws ServiceException;

	/**
	 * Clear cart for user.
	 *
	 * @param userMaster the user master
	 * @throws ServiceException
	 */
	void clearCartForUser(UserMaster userMaster) throws ServiceException;

}
