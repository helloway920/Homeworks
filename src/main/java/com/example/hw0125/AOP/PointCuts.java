package com.example.hw0125.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class PointCuts {
    @Pointcut("within(com.example.hw0125.DAO..*)")
    public void inDataAccessLayer() {}
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void methodWithinClassWithAnnotationRestController() {}
}
