package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class InvalidUserException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid user.")
public class InvalidUserException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public InvalidUserException(final String user) {
		super(user + " not found.");
	}

}
