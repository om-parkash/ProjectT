package com.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.domain.Cart;
import com.shoppingcart.domain.ShoppingItem;
import com.shoppingcart.domain.UserMaster;

/**
 * Template to fetch cart from database.
 */
public interface CartDao extends CrudRepository<Cart, Serializable> {

	/**
	 * Find all by user master.
	 *
	 * @param userMaster the user master
	 * @return the list
	 */
	List<Cart> findAllByUserMaster(UserMaster userMaster);

	/**
	 * Find by user master and item.
	 *
	 * @param master the master
	 * @param shoppingItem the shopping item
	 */
	void findByUserMasterAndItem(UserMaster master, ShoppingItem shoppingItem);

	/**
	 * Delete by user master and item.
	 *
	 * @param master the master
	 * @param item the item
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from Cart c where c.userMaster=:userMaster and c.item=:item")
	void deleteByUserMasterAndItem(@Param("userMaster") UserMaster master, @Param("item") ShoppingItem item);

	/**
	 * Find one by user master and item and quantity.
	 *
	 * @param master the master
	 * @param item the item
	 * @param quantity the quantity
	 * @return the cart
	 */
	Cart findOneByUserMasterAndItemAndQuantity(UserMaster master, ShoppingItem item, Integer quantity);

	/**
	 * Delete by user master.
	 *
	 * @param master the master
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from Cart c where c.userMaster=:userMaster")
	void deleteByUserMaster(@Param("userMaster") UserMaster master);

	/**
	 * Find one by user master and item.
	 *
	 * @param userMaster the user master
	 * @param shoppingItem the shopping item
	 * @return the cart
	 */
	Cart findOneByUserMasterAndItem(UserMaster userMaster, ShoppingItem shoppingItem);

}
