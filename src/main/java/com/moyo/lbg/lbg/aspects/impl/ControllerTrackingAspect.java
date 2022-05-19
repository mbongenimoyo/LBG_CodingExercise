package com.moyo.lbg.lbg.aspects.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class ControllerTrackingAspect {

    private final Logger LOGGER= LogManager.getLogger(ControllerTrackingAspect.class);

    @Before("@annotation(com.moyo.lbg.lbg.aspects.ControllerTracking)")
    public void LogRestCallsBefore(JoinPoint point){
        LOGGER.info("Before Execution - Request parameters: " +point.getArgs()[0].toString());
    }

    @AfterReturning(pointcut = "@annotation(com.moyo.lbg.lbg.aspects.ControllerTracking)")
    public void checkSomethingAfter(JoinPoint joinPoint) {
        LOGGER.info("FINISHED REST CALL AT:"+new Date(System.currentTimeMillis()));

    }
}
