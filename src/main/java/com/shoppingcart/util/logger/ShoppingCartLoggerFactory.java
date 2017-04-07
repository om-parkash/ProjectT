package com.shoppingcart.util.logger;

import org.apache.log4j.Logger;

/**
 * A factory for creating ShoppingCartLogger objects.
 */
public final class ShoppingCartLoggerFactory {

	// private constructor to prevent instantiation
	private ShoppingCartLoggerFactory() {

	}

	/**
	 * Returns an instance of Shopping Cart Logger from factory.
	 * 
	 * @param classType {@link Class} - Class name for which logger is required.
	 * @return instance of {@link EphesoftLogger}
	 */
	public static ShoppingCartLogger getLogger(final Class<?> classType) {

		final Logger logger = Logger.getLogger(classType.getName());
		return new ShoppingCartLoggerImpl(logger);

	}
}
