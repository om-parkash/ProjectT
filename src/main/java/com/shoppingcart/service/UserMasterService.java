package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.exception.ServiceException;

/**
 * Service to fetch user.
 * 
 */
public interface UserMasterService {

	/**
	 * Returns user that matches with specified name and password.
	 * 
	 * @param userName {@link String} of user to be returned.
	 * @param password {@link String} of user to be returned.
	 * @return {@link UserMaster} that matches with specified name and password.
	 * @throws ServiceException
	 */
	UserMaster fetchUserMasterByUserNamePassword(String userName, String password) throws ServiceException;

	/**
	 * Returns user that matches with specified userId.
	 * 
	 * @param userId {@link Integer} of user to be returned.
	 * @return {@link UserMaster} that matches with userId.
	 * @throws ServiceException
	 */
	UserMaster fetchUserMasterById(Integer userId) throws ServiceException;

	/**
	 * Returns all the users.
	 * 
	 * @return {@link List<UserMaster>} of all users.
	 * @throws ServiceException
	 */
	List<UserMaster> fetchAllUserMaster() throws ServiceException;
}
