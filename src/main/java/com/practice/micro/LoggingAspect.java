package com.practice.micro;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	
	@Before("execution(* com.practice.micro.*.*(..))")
	public void logArguments(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		log.info(" In {}.{} args {}",className,methodName,args);

	}

}
