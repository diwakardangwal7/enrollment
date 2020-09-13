package com.diwakar.enrollment.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logging Aspect for tracing execution time of every method
 * @author Diwakar
 */


@Aspect
@Component
public class EnrollmentLoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(EnrollmentLoggingAspect.class);

	@Before(EnrollmentLoggingConstants.LOG_ALL_METHODS)
	public void logBeforeMethod(JoinPoint joinPoint) {

		logger.info(EnrollmentLoggingConstants.METHOD_ENTRY_LOG + joinPoint.getSignature().getDeclaringType()
				+ EnrollmentLoggingConstants.METHOD_LOG_SEPARATOR + joinPoint.getSignature().getName());
	}

	@After(EnrollmentLoggingConstants.LOG_ALL_METHODS)
	public void logAfterMethod(JoinPoint joinPoint) {

		logger.info(EnrollmentLoggingConstants.METHOD_EXIT_LOG + joinPoint.getSignature().getDeclaringType()
				+ EnrollmentLoggingConstants.METHOD_LOG_SEPARATOR + joinPoint.getSignature().getName());
	}

	@Pointcut(EnrollmentLoggingConstants.POINT_CUT_BASE_PACKAGE)
	public void allMethodsPointcut() {

		
	}
}
