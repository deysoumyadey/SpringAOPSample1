package com.som.aspectj.aspectjexample.aspect;

import com.som.aspectj.aspectjexample.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    //@Before("allGetters() && allCircleMethods()")
    @Before("allCircleMethods()")
    public void LoggingAdvice(JoinPoint joinPoint){
        /*Circle circle = (Circle) joinPoint.getTarget();
        System.out.println(
                circle.getName()
                //joinPoint.toString()
                /*"Advice run. Get Method called"*/
       /* );*/
    }

    //@After("args(name)")
    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethod(String name, String returnString){
        System.out.println("A method that takes String arguments has been called. The value is: " + name + ". The output value is: " + returnString);

    }

    //@AfterThrowing("args(name)")
    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void exceptionAdvice(String name, RuntimeException ex){
        System.out.println("An exception has been thrown " + ex);
        ex.printStackTrace();
    }

    @Before("allGetters()")
    public void secondAdvice(){
        System.out.println("Second advice.");
    }

    //@Around("allGetters()")
    @Around("@annotation(com.som.aspectj.aspectjexample.aspect.Loggable)")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint/*1st you need to have proceedingjoinpoint as one of the argument*/){
        Object returnValue = null;
        try {
            System.out.println("Before Advice");

            //2nd Around advice rule is to have the below line
            returnValue = proceedingJoinPoint.proceed();
        }catch (Throwable e){
            System.out.println("After Returning");
        }
        System.out.println("After Finally");
        return returnValue;
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
