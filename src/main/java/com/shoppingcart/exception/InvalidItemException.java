package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InvalidItemException exception handles if invalid item is entered.
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Item")
public class InvalidItemException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public InvalidItemException(final Integer itemId) {
		super("ItemId " + itemId + " not found.");
	}

}
