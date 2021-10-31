/**
 * 
 */
package com.neilly.peely.exception;

/**
 * @author mcalv
 *
 */
public class PasswordResetTokenInvalidException extends RuntimeException{

	/**
	 * 
	 */
	public PasswordResetTokenInvalidException() {
	}

	/**
	 * @param message
	 */
	public PasswordResetTokenInvalidException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PasswordResetTokenInvalidException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PasswordResetTokenInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PasswordResetTokenInvalidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
