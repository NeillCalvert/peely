/**
 * 
 */
package com.neilly.peely.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.logging.LogLevel;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * @author mcalv
 *
 */
public @interface GenericLogger {
	LogLevel logLevel() default LogLevel.INFO;
	boolean logExecutionTime() default true;
	boolean logMethodArgs() default true;
	boolean logCustomMessage() default false;
	String customMessage();
}
