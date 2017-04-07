package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.UserMasterDAO;
import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.exception.DaoException;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.util.logger.ShoppingCartLogger;
import com.shoppingcart.util.logger.ShoppingCartLoggerFactory;

/**
 * Implementation of {@link UserMasterService}.
 * 
 */
@Service("UserMasterService")
public class UserMasterServiceImpl implements UserMasterService {

	/**
	 * Logger instance to log messages in log file.
	 */
	private static final ShoppingCartLogger LOGGER = ShoppingCartLoggerFactory.getLogger(UserMasterServiceImpl.class);

	/**
	 * UserMasterDAO autowired.
	 */
	@Autowired
	private UserMasterDAO userMasterDAO;

	/**
	 * Returns user that matches with specified name and password.
	 * 
	 * @param userName {@link String} of user to be returned.
	 * @param password {@link String} of user to be returned.
	 * @return {@link UserMaster} that matches with specified name and password.
	 * @throws ServiceException
	 */
	public UserMaster fetchUserMasterByUserNamePassword(final String userName, final String password) throws ServiceException {
		UserMaster userMaster = null;
		try {
			userMaster = userMasterDAO.findOneByUserNameAndPassword(userName, password);
		} catch (DaoException daoException) {
			final String errorMessage = "Error occurred while fetching user master for username" + userName;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return userMaster;
	}

	/**
	 * Returns user that matches with specified userId.
	 * 
	 * @param userId {@link Integer} of user to be returned.
	 * @return {@link UserMaster} that matches with userId.
	 * @throws ServiceException
	 */
	public UserMaster fetchUserMasterById(final Integer userId) throws ServiceException {

		UserMaster userMaster = null;
		try {
			userMaster = userMasterDAO.findOneByUserId(userId);
		} catch (DaoException daoException) {
			final String errorMessage = "Error occurred while fetching user master for userId" + userId;
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return userMaster;
	}

	/**
	 * Returns all the users.
	 * 
	 * @return {@link List<UserMaster>} of all users.
	 * @throws ServiceException
	 */
	public List<UserMaster> fetchAllUserMaster() throws ServiceException {
		List<UserMaster> userMasterList = null;
		try {
			userMasterList = userMasterDAO.findAll();
		} catch (DaoException daoException) {
			String errorMessage = "Error occurred while fetching all users.";
			LOGGER.error(errorMessage);
			throw new ServiceException(errorMessage, daoException);
		}
		return userMasterList;
	}

}
