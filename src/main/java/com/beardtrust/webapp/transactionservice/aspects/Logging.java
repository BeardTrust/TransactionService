package com.beardtrust.webapp.transactionservice.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * This class handles the logging aspect by logging the calling and
 * the returning of each function or method at the join point.
 *
 * @author Matthew Crowell <Matthew.Crowell@Smoothstack.com>
 */
@Aspect
@Component
@Slf4j
public class Logging {

	/**
	 * This method takes a join point as an argument and logs the function
	 * call signature and arguments.
	 *
	 * @param joinPoint	JoinPoint the specified join point
	 */
	@Before("execution(* com.beardtrust.webapp.transactionservice.*.*.*(..))")
	public void logMethodInvocation(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.trace("Calling " + className + "." + methodName + "(" + Arrays.toString(args) + ")");
	}

	/**
	 * This method takes a join point as an argument and logs the returning
	 * function's signature and arguments.
	 *
	 * @param joinPoint	JoinPoint the specified join point
	 */
	@After("execution(* com.beardtrust.webapp.transactionservice.*.*.*(..))")
	public void logMethodReturn(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.trace("Returning from " + className + "." + methodName + "(" + Arrays.toString(args) + ")");
	}
}
