package com.sharad.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
    @InjectMocks
    Calculator calculator;

    @Test
    public void testAdd() {
//        Calculator calculator = new Calculator();
        int result = calculator.add(3,3);
        assert (result==6);
    }

    @Mock
    private CalculateArea mockCalculateArea;

    @Test
    public void testCalculateArea() {
        float actualValue=23.5F;
        when(mockCalculateArea.circleArea(anyFloat())).thenReturn(actualValue);
        float expectedValue=calculator.areaCalculateCircle(9);
        assert (actualValue == expectedValue);
        verify (mockCalculateArea, atLeast(1)).circleArea(anyFloat());
    }
}