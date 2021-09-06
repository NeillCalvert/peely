/**
 * 
 */
package com.neilly.peely.globalexceptionhandler;

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
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", NOT_FOUND_EXCEPTION_MESSAGE);
		
		exceptionLogger.error(exception.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", EXCEPTION_MESSAGE);
		
		exceptionLogger.error(exception.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

