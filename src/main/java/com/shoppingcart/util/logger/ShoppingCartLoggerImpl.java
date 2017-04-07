package com.shoppingcart.util.logger;

import org.apache.log4j.Logger;

import com.shoppingcart.util.ShoppingCartStringUtil;

/**
 * The Class ShoppingCartLoggerImpl.
 */
public class ShoppingCartLoggerImpl implements ShoppingCartLogger {

	/**
	 * logger {@link Logger}.
	 */
	private final Logger logger;

	/**
	 * An instance of EphesoftLoggerImpl.
	 * 
	 * @param logger The logger instance to be used for logging.
	 */
	public ShoppingCartLoggerImpl(final Logger logger) {
		this.logger = logger;
	}

	/**
	 * Log a message at the ERROR level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	public void error(final Object... msgParams) {
		final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
		this.logger.error(msgStr);
	}

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message.
	 *
	 * @param throwable {@link Throwable} the exception (throwable) to log
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	public void error(final Throwable throwable, final Object... msgParams) {
		final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
		this.logger.error(msgStr, throwable);
	}

	/**
	 * Log a message at the DEBUG level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	public void debug(final Object... msgParams) {
		if (this.isDebugEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
			this.logger.debug(msgStr);
		}
	}

	/**
	 * Log an exception (throwable) at the DEBUG level with an accompanying message.
	 *
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	public void debug(final Throwable throwable, final Object... msgParams) {
		if (this.isDebugEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
			this.logger.debug(msgStr, throwable);
		}

	}

	/**
	 * Log a message at the TRACE level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	public void trace(final Object... msgParams) {
		if (this.isTraceEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
			this.logger.trace(msgStr);
		}
	}

	/**
	 * Log an exception (throwable) at the TRACE level with an accompanying message.
	 *
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	public void trace(final Throwable throwable, final Object... msgParams) {
		if (this.isTraceEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
			this.logger.trace(msgStr, throwable);
		}
	}

	/**
	 * Log a message at the INFO level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	public void info(final Object... msgParams) {
		if (this.isInfoEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
			this.logger.info(msgStr);
		}
	}

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying message.
	 *
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	public void info(final Throwable throwable, final Object... msgParams) {
		if (this.isInfoEnabled()) {
			final String msgStr = ShoppingCartStringUtil.concatenate(null, msgParams);
			this.logger.info(msgStr, throwable);
		}
	}

	/**
	 * Log a message at the warn level.
	 * 
	 * @param msgParams {@link Object} the message string to be appended before logging.
	 */
	public void warn(final Object... msgParams) {
		final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
		this.logger.warn(msgStr);
	}

	/**
	 * Log an exception (throwable) at the warn level with an accompanying message.
	 *
	 * @param throwable {@link Throwable} the exception (throwable) to log.
	 * @param msgParams {@link Object} the message accompanying the exception.
	 */
	public void warn(final Throwable throwable, final Object... msgParams) {

		final String msgStr = ShoppingCartStringUtil.concatenate(msgParams);
		this.logger.warn(msgStr, throwable);

	}

	/**
	 * Is the logger instance enabled for the DEBUG level?.
	 *
	 * @return True if this Logger is enabled for the DEBUG level, false otherwise.
	 */
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	/**
	 * Is the logger instance enabled for the INFO level?.
	 *
	 * @return True if this Logger is enabled for the INFO level, false otherwise.
	 */
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	/**
	 * Is the logger instance enabled for the TRACE level?.
	 *
	 * @return True if this Logger is enabled for the TRACE level, false otherwise.
	 */
	public boolean isTraceEnabled() {
		return this.logger.isTraceEnabled();
	}

}
