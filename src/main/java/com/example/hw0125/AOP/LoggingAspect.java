package com.example.hw0125.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class LoggingAspect {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("com.example.hw0125.AOP.PointCuts.inDataAccessLayer()")
    public Object executionTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.warn("before processed");

        Object result = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - startTime;
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        log.warn(className + "." + methodName + " execution time: " + elapsedTime + " ms " + "result: " + result);
        return result;
    }

    @Around("com.example.hw0125.AOP.PointCuts.methodWithinClassWithAnnotationRestController()")
    public Object requestAndResponse(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        log.warn("Request: " + request.toString());
        Object result = pjp.proceed();
        final HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
        log.warn("Response: " + response.toString());
        return result;

    }
}
