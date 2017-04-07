package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InvalidQuantityException exception handles if invalid quantity is entered.
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid quantity")
public class InvalidQuantityException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public InvalidQuantityException(final Integer itemId) {
		super("ItemId " + itemId + " not found.");
	}

}
