package com.sharad.app;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final CalculateArea calculateArea;

    public Calculator(CalculateArea calculateArea) {
        this.calculateArea = calculateArea;
    }
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int division(int a, int b) {
        return a / b;
    }
    public float areaCalculateCircle(float a) {
        return calculateArea.circleArea(a);
    }
}