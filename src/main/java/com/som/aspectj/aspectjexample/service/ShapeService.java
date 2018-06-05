package com.som.aspectj.aspectjexample.service;

import com.som.aspectj.aspectjexample.aspect.Loggable;
import com.som.aspectj.aspectjexample.model.Circle;
import com.som.aspectj.aspectjexample.model.Triangle;


public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Circle getCircle() {
        System.out.println("ShapeService Circle Getter called.");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Loggable
    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
