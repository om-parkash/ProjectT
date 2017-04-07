package com.shoppingcart.util.logger;

/**
 * The Interface ShoppingCartLogger.
 */
public interface ShoppingCartLogger {

	/**
	 * Log a message at the ERROR level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	void error(final Object... msgParams);

	/**
	 * Log a message at the DEBUG level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	void debug(final Object... msgParams);

	/**
	 * Log a message at the TRACE level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	void trace(final Object... msgParams);

	/**
	 * Log a message at the INFO level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	void info(final Object... msgParams);

	/**
	 * Log a message at the warn level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	void warn(final Object... msgParams);

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message.
	 * 
	 * @param throwable {@link Throwable} the exception (throwable) to log
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	void error(final Throwable throwable, final Object... msgParams);

	/**
	 * Log an exception (throwable) at the DEBUG level with an accompanying message.
	 * 
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	void debug(final Throwable throwable, final Object... msgParams);

	/**
	 * Log an exception (throwable) at the TRACE level with an accompanying message.
	 * 
	 * @param msgParams {@link Object} the message accompanying the exception.
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 */
	void trace(final Throwable throwable, final Object... msgParams);

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying message.
	 * 
	 * @param msgParams {@link Object} the message accompanying the exception.
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 */
	void info(final Throwable throwable, final Object... msgParams);

	/**
	 * Log an exception (throwable) at the warn level with an accompanying message.
	 * 
	 * @param msgParams {@link Object} the message accompanying the exception.
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 */
	void warn(final Throwable throwable, final Object... msgParams);

	/**
	 * An API to check if TRACE level logs are enabled.
	 */

	boolean isTraceEnabled();

	/**
	 * An API to check if INFO level logs are enabled.
	 */
	boolean isInfoEnabled();

	/**
	 * An API to check if DEBUG level logs are enabled.
	 */
	boolean isDebugEnabled();

}
