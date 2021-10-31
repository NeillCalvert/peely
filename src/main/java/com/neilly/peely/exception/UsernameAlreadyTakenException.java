/**
 * 
 */
package com.neilly.peely.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mcalv
 *
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Username already exists")
public class UsernameAlreadyTakenException extends RuntimeException {

	/**
	 * 
	 */
	public UsernameAlreadyTakenException() {
	}

	/**
	 * @param message
	 */
	public UsernameAlreadyTakenException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UsernameAlreadyTakenException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UsernameAlreadyTakenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UsernameAlreadyTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
