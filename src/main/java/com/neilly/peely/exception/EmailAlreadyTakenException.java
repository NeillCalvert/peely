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
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Email already exists")
public class EmailAlreadyTakenException extends RuntimeException{

	/**
	 * 
	 */
	public EmailAlreadyTakenException() {
	}

	/**
	 * @param message
	 */
	public EmailAlreadyTakenException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmailAlreadyTakenException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmailAlreadyTakenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmailAlreadyTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
