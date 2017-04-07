package com.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.domain.ItemOrderMaster;
import com.shoppingcart.domain.UserMaster;

/**
 * Template to fetch shopping items from database.
 * 
 */
public interface ItemOrderMasterDAO extends CrudRepository<ItemOrderMaster, Serializable> {

	/**
	 * Returns order of specified user from database.
	 *
	 * @param userMaster the user master
	 * @return the list
	 */
	List<ItemOrderMaster> findByUserMaster(UserMaster usermaster);

	/**
	 * Returns all orders from database.
	 * 
	 * @return {@link List<ItemOrderMaster>} of all orders placed.
	 */
	List<ItemOrderMaster> findAll();

}
