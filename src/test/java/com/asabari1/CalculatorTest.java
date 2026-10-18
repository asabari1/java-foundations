package com.asabari1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void addsPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }
    @Test
    void addsNegativeNumbers() {
        assertEquals(-14, calculator.add(-12,-2));
    }
    @Test
    void addsMixedNumbers() {
        assertEquals(-10, calculator.add(-12,2));
    }
    @Test
    void addsZero() {
        assertEquals(5, calculator.add(0,5));
    }
}
