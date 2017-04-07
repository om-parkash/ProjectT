package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.dto.OrderDto;
import com.shoppingcart.exception.ServiceException;

/**
 * Service to fetch shopping items.
 */
public interface ItemOrderMasterService {

	/**
	 * Process order.
	 *
	 * @param userName the user name
	 * @param itemId the item id
	 * @param quantity the quantity
	 * @return the order dto
	 * @throws ServiceException
	 */
	OrderDto processOrder(UserMaster userName, Integer itemId, Integer quantity) throws ServiceException;

	/**
	 * Process order.
	 *
	 * @param userName the user name
	 * @return the order dto
	 * @throws ServiceException
	 */
	OrderDto processOrder(UserMaster userName) throws ServiceException;

	/**
	 * Fetch all orders.
	 *
	 * @param master the master
	 * @return the list
	 * @throws ServiceException
	 */
	List<OrderDto> fetchAllOrders(UserMaster master) throws ServiceException;

}
