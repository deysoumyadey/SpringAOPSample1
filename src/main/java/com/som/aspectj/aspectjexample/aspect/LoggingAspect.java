package com.som.aspectj.aspectjexample.aspect;

import com.som.aspectj.aspectjexample.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    //@Before("allGetters() && allCircleMethods()")
    @Before("allCircleMethods()")
    public void LoggingAdvice(JoinPoint joinPoint){
        Circle circle = (Circle) joinPoint.getTarget();
        System.out.println(
                circle.getName()
                //joinPoint.toString()
                /*"Advice run. Get Method called"*/
        );
    }

    @Before("args(name)")
    public void stringArgumentMethod(String name){
        System.out.println("A method that takes String arguments has been called. The value is " + name);
    }


    @Before("allGetters()")
    public void secondAdvice(){
        System.out.println("Second advice.");
    }

    @Pointcut("execution(* get*())")
    public void allGetters(){}

    @Pointcut("within(com.som.aspectj.aspectjexample.model.Circle)")
    public void allCircleMethods(){}


    /*@Before("execution(public String com.som.aspectj.aspectjexample.model.Circle.getName())")
    public void LoggingAdviceCircle(){
        System.out.println("Advice run for Circle. Get Method called");
    }

    @Before("execution(public String com.som.aspectj.aspectjexample.model.Triangle.getName())")
    public void LoggingAdviceTriangle(){
        System.out.println("Advice run for Triangle. Get Method called");
    }*/
}
