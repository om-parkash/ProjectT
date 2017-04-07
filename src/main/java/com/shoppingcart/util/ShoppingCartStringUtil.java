package com.shoppingcart.util;

/**
 * Performs methods like concatenate, encode, split, null check, etc. on strings.
 * 
 */
public final class ShoppingCartStringUtil {

	private ShoppingCartStringUtil() {
		super();
	}

	/**
	 * Checks if a string is null or empty.
	 * 
	 * @param paramToCheck {@link String} String to check for empty or null
	 * @return boolean true is paramToCheck is null or empty.
	 */
	public static boolean isNullOrEmpty(final String paramToCheck) {
		return null == paramToCheck || paramToCheck.isEmpty();
	}

	/**
	 * Concatenates a number of objects together in the form of a String.
	 * 
	 * @param objects {@link Object} Objects for concatenation to form a String.
	 * @return {@link String} concatenated string, null if objects is null.
	 */
	public static String concatenate(final Object... objects) {
		String concatenatedString = null;
		if (null != objects) {
			StringBuilder concatenatedStringBuilder = null;
			for (final Object object : objects) {
				if (null == concatenatedStringBuilder) {
					concatenatedStringBuilder = new StringBuilder();
				}
				if (null != object) {
					concatenatedStringBuilder.append(object);
				}
			}
			concatenatedString = concatenatedStringBuilder.toString();
		}
		return concatenatedString;
	}

}
