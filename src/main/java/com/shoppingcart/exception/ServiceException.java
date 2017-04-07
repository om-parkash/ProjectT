package com.shoppingcart.exception;

/**
 * ServiceException is to handle exception occurred at service layer.
 *
 */
public class ServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ServiceException() {
		super();

	}
}
