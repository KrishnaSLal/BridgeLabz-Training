package com.employee.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingInterceptor.class);

    private static final String START_TIME =
            "requestStartTime";

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        request.setAttribute(
                START_TIME,
                System.currentTimeMillis()
        );

        logger.info(
                "Request started: {} {}",
                request.getMethod(),
                request.getRequestURI()
        );

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception exception) {

        Long startTime =
                (Long) request.getAttribute(START_TIME);

        long executionTime =
                System.currentTimeMillis() - startTime;

        if (exception != null) {

            logger.error(
                    "Request failed: {} {} | Status: {} | Time: {} ms",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    executionTime,
                    exception
            );

        } else {

            logger.info(
                    "Request completed: {} {} | Status: {} | Time: {} ms",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    executionTime
            );
        }
    }
}