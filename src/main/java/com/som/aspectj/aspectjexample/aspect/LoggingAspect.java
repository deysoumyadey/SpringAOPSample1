package com.som.aspectj.aspectjexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Before("allGetters()")
    public void LoggingAdvice(){
        System.out.println("Advice run. Get Method called");
    }

    @Before("allGetters()")
    public void secondAdvice(){
        System.out.println("Second advice.");
    }

    @Pointcut("execution(* get*())")
    public void allGetters(){
        System.out.println("Advice for all Getters");
    }

    @Pointcut("within(com.som.aspectj.aspectjexample.model..*)")
    public void allCircleMethods(){
        System.out.println("All Circle Method called.");
    }

    @Before("execution(public String com.som.aspectj.aspectjexample.model.Circle.getName())")
    public void LoggingAdviceCircle(){
        System.out.println("Advice run for Circle. Get Method called");
    }

    @Before("execution(public String com.som.aspectj.aspectjexample.model.Triangle.getName())")
    public void LoggingAdviceTriangle(){
        System.out.println("Advice run for Triangle. Get Method called");
    }
}
