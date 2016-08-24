package de.kimminich.agile.solutions.lecture5;

import de.kimminich.agile.demos.lecture5.Calculator;
import de.kimminich.agile.demos.lecture5.CalculatorImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void testSum() {
        Assert.assertEquals(0, calculator.sum(0, 0));
        assertEquals(1, calculator.sum(0, 1));
    }

    @Test
    public void testModulo() {
        assertEquals(0, calculator.modulo(0, 1));
    }

    @Test
    public void testDivision() {
        assertEquals(1, calculator.div(1.0, 1.0), 0.00000001);
    }

    @Test
    public void testMin() {
        assertEquals(1, calculator.min(1, 2));
        assertEquals(1, calculator.min(2, 1));
        assertEquals(-2, calculator.min(-2, 1));
    }

    @Test
    public void testMax() {
        assertEquals(2, calculator.max(1, 2));
        assertEquals(2, calculator.max(2, 1));
        assertEquals(1, calculator.max(-2, 1));
    }
}
