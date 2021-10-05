/**
 * 
 */
package com.neilly.peely.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javassist.NotFoundException;

/**
 * @author neill
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
 
	private static final Logger exceptionLogger = LogManager.getLogger(GlobalExceptionHandler.class); 
	public static final String NOT_FOUND_EXCEPTION_MESSAGE = "404: Item Not Found";
	public static final String EXCEPTION_MESSAGE = "500: Something went wrong";
	
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 409
	public ResponseEntity<Object> handleNotFound(NotFoundException exception, WebRequest request) {
		
		return new ResponseEntity<>(createHttpResponseBody(NOT_FOUND_EXCEPTION_MESSAGE), HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException exception, WebRequest request) {

    	return new ResponseEntity<>(createHttpResponseBody(exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);	
    }
    
    @ExceptionHandler(UsernameAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleUsernameTakenException(Exception exception, WebRequest request) {
		
		return new ResponseEntity<>(createHttpResponseBody(exception.getMessage()), HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
		
		return new ResponseEntity<>(createHttpResponseBody(EXCEPTION_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public Map<String, Object> createHttpResponseBody(String message){
    	Map<String, Object> body = new LinkedHashMap<>();
    	body.put("timestamp", LocalDateTime.now());
    	body.put("message", message);
    	
    	exceptionLogger.error(message);
    	
    	return body;
    }

}

