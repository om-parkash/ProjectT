package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CustomException is any unknown error occurs in application.
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Unknown exception occurs.")
public class GenericException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public GenericException(final String message) {
		super(message);
	}

	public GenericException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public GenericException() {
		super();

	}
}
