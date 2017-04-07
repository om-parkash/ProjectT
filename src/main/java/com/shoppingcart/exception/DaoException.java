package com.shoppingcart.exception;

import org.springframework.dao.DataAccessException;

/**
 *	DaoException is to handle dao layer exceptions. 
 *
 */
public class DaoException extends DataAccessException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public DaoException(final String message) {
		super(message);
	}

	public DaoException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
