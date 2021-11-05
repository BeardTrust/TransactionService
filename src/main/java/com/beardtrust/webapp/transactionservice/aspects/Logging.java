package com.beardtrust.webapp.transactionservice.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class Logging {

	@Before("execution(* com.beardtrust.webapp.transactionservice.*.*.*(..))")
	public void logMethodInvocation(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.trace("Calling " + className + "." + methodName + "(" + Arrays.toString(args) + ")");
	}

	@After("execution(* com.beardtrust.webapp.transactionservice.*.*.*(..))")
	public void logMethodReturn(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.trace("Returning from " + className + "." + methodName + "(" + Arrays.toString(args) + ")");
	}
}
