package com.som.aspectj.aspectjexample.service;

import com.som.aspectj.aspectjexample.model.Circle;

public class ShapeServiceProxy extends ShapeService {
    public Circle getCircle() {
        System.out.println("Aspect can be called here.");
        return super.getCircle();
    }
}
