package com.fundoonotes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.fundoonotes.service..*(..))")
    public Object logServiceMethods(
            ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName =
                joinPoint.getSignature().getName();

        long startTime =
                System.currentTimeMillis();

        log.info("Entering method: {}", methodName);

        try {

            Object result =
                    joinPoint.proceed();

            long executionTime =
                    System.currentTimeMillis()
                    - startTime;

            log.info(
                    "Exiting method: {} | Execution time: {} ms",
                    methodName,
                    executionTime
            );

            return result;

        } catch (Exception exception) {

            long executionTime =
                    System.currentTimeMillis()
                    - startTime;

            log.error(
                    "Exception in method: {} | Execution time: {} ms | Message: {}",
                    methodName,
                    executionTime,
                    exception.getMessage()
            );

            throw exception;
        }
    }
}