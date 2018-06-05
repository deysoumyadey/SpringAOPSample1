package com.som.aspectj.aspectjexample.service;

import com.som.aspectj.aspectjexample.model.Circle;
import com.som.aspectj.aspectjexample.model.Triangle;

public class FactoryService {

    public Object getBean(String beanType){
        if(beanType.equals("shapeService")) return new ShapeServiceProxy();
        if(beanType.equals("circle")) return new Circle();
        if(beanType.equals("triangle")) return new Triangle();
        return null;
    }
}
