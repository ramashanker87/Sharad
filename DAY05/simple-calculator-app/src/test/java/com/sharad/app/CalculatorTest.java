package com.sharad.app;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(5,5);
        assert result==10;
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(4,2);
        assert result==2;
    }
    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        double result = calculator.multiply(5,5);
        assert result==25;
    }

}