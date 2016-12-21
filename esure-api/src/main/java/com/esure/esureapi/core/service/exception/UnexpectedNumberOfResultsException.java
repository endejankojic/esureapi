package com.esure.esureapi.core.service.exception;

import com.esure.esureapi.core.exception.EsureApiRuntimeException;

/**
 * This class represents custom exception of EsureApi application module if unexpected number of some object is returned
 * from data store.
 */
public class UnexpectedNumberOfResultsException extends EsureApiRuntimeException {

	private static final long serialVersionUID = 1L;

	public UnexpectedNumberOfResultsException() {
		super();
	}

	/**
	 * @param message
	 */
	public UnexpectedNumberOfResultsException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnexpectedNumberOfResultsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public UnexpectedNumberOfResultsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	protected UnexpectedNumberOfResultsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
