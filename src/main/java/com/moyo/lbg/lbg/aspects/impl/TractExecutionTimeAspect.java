package com.moyo.lbg.lbg.aspects.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TractExecutionTimeAspect {
    private static final Logger LOGGER = LogManager.getLogger(TractExecutionTimeAspect.class);

    @Around("@annotation(com.moyo.lbg.lbg.aspects.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable{
        MethodSignature methodSignature=(MethodSignature) point.getSignature();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result=point.proceed();
        stopWatch.stop();

        LOGGER.info("Class Name: "+point.getSignature().getDeclaringTypeName()+". Method Name: "+point.getSignature().getName()+". Execution Time: "+stopWatch.getTotalTimeMillis());
        return  result;
    }

}
