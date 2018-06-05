package com.som.aspectj.aspectjexample;

import com.som.aspectj.aspectjexample.model.Circle;
import com.som.aspectj.aspectjexample.service.ShapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan(basePackages = "com.som.aspectj.aspectjexample")
public class AspectjexampleApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        ShapeService shapeService = ctx.getBean(ShapeService.class);
        System.out.println(shapeService.getCircle().getName());
    }
}
