package com.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.domain.UserMaster;

/**
 * Template to fetch user from database.
 * 
 */
public interface UserMasterDAO extends CrudRepository<UserMaster, Serializable> {

	/**
	 * Returns user that matches with specified name and password.
	 * 
	 * @param userName {@link String} of user to be fetched.
	 * @param password {@link String} of user to be fetched.
	 * @return {@link UserMaster} that matches with specified name and password from database.
	 */
	UserMaster findOneByUserNameAndPassword(String userName, String password);

	/**
	 * Returns user that matches with specified userId from database.
	 * 
	 * @param userId {@link Integer} of user to be fetched.
	 * @return {@link UserMaster} that matches with userId.
	 */
	UserMaster findOneByUserId(Integer userId);

	/**
	 * Returns all the users from databse.
	 * 
	 * @return {@link List<UserMaster>} of all users.
	 */
	List<UserMaster> findAll();
}
