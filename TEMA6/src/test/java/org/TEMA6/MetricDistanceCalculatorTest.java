package org.TEMA6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetricDistanceCalculatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateDistance_ShouldReturnCorrectValue() {
        String expression = "10 cm + 1 m - 10 mm";
        int result = MetricDistanceCalculator.calculateDistance(expression);
        assertEquals(1090, result);
    }

    @Test
    public void calculateDistance_ShouldHandleZero() {
        String expression = "0 mm + 0 cm - 0 m";
        int result = MetricDistanceCalculator.calculateDistance(expression);
        assertEquals(0, result);
    }

    @Test
    public void calculateDistance_ShouldHandleSingleUnit() {
        String expression = "5 km";
        int result = MetricDistanceCalculator.calculateDistance(expression);
        assertEquals(5000000, result);
    }
}