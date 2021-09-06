/**
 * 
 */
package com.neilly.peely.aspect;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

/**
 * @author neill
 * Global logger allowing methods to be logged using the @GenericLogger annotation
 *
 */
@Aspect
@Component
public class GlobalLogger {
	
	public static final String METHOD_NAME_PREFIX = " Method Executed: ";
	public static final String METHOD_PARAMS_PREFIX = ", Method Params: ";
	public static final String CUSTOM_LOG_MESSAGE_PREFIX = ", Log Message: ";
	public static final String METHOD_NAME_COMPLETED = " Method Completed: ";
	public static final String METHOD_EXECUTION_TIME = ", Method Execution Time: ";
	public static final String METHOD_EXECUTION_TIME_UNITS = "ms";
	
	private static final Logger logger = LogManager.getLogger(GlobalLogger.class);
	
	@Around("@annotation(GenericLogger)")
	public Object publishGenericLogMessage(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String methodName = method.getName();
		GenericLogger annotation = method.getAnnotation(GenericLogger.class);
		LogLevel logLevel = annotation.logLevel();
		long start = System.currentTimeMillis();
		
		String logEntryMessage = createLogEntryMessage(joinPoint, signature, method, annotation);
		publishLogMessage(logLevel, logEntryMessage);
		
		Object proceed = joinPoint.proceed();
		
		long executionTime = System.currentTimeMillis() - start;
		String logExitMessage = createLogExitMessage(methodName, executionTime);
		publishLogMessage(logLevel, logExitMessage);
		
		return proceed;
	}
	
	public String createLogEntryMessage(ProceedingJoinPoint joinPoint, MethodSignature methodSignature, Method method, GenericLogger annotation) {
		boolean logMethodArgs = annotation.logMethodArgs();
		boolean logCustomMessage = annotation.logCustomMessage();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(METHOD_NAME_PREFIX);
		stringBuilder.append(method.getName());
		
		if(logMethodArgs && method.getParameterCount() != 0) {
			stringBuilder.append(METHOD_PARAMS_PREFIX);			
			stringBuilder.append(getMethodArgs(joinPoint, methodSignature).toString());
		}
		
		if(logCustomMessage){
			stringBuilder.append(CUSTOM_LOG_MESSAGE_PREFIX);
			stringBuilder.append(annotation.customMessage());
		}
		
		return stringBuilder.toString();
	}
	
	public String createLogExitMessage(String methodName, long executionTime) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(METHOD_NAME_COMPLETED);
		stringBuilder.append(methodName);
		stringBuilder.append(METHOD_EXECUTION_TIME);
		stringBuilder.append(executionTime);
		stringBuilder.append(METHOD_EXECUTION_TIME_UNITS);
		
		return stringBuilder.toString();
	}
	
	public Map<String, Object> getMethodArgs(ProceedingJoinPoint joinPoint, MethodSignature methodSignature) {
		String[] argNames = methodSignature.getParameterNames();
		Object[] args = joinPoint.getArgs();
		Map<String, Object> methodArgs = new HashMap<>();
		
		for(int i = 0; i < argNames.length; i++) {
			methodArgs.put(argNames[i], args[i]);
		}
		
		return methodArgs;
	}
	
	public void publishLogMessage(LogLevel level, String message) {
		switch(level) {
		case ERROR : 
			logger.error(message);
			break;
		case DEBUG :
			logger.debug(message);
			break;
		case WARN : 
			logger.warn(message);
			break;
		default :
			logger.info(message);
		}
	}

}
