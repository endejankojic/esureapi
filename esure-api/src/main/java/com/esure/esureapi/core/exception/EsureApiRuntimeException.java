package com.esure.esureapi.core.exception;

/**
 * This class represents runtime exception of EsureApi application.
 */
public class EsureApiRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EsureApiRuntimeException() {
		super();
	}

	/**
	 * @param message
	 */
	public EsureApiRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EsureApiRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public EsureApiRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	protected EsureApiRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
