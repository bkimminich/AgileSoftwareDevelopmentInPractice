package de.kimminich.agile.lecture5.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorUnitTest {

	@Test
	public void testSum() {
		assertEquals(0, Calculator.sum(0, 0));
		assertEquals(1, Calculator.sum(0, 1));
	}

	@Test
	public void testModulo() {
		assertEquals(0, Calculator.modulo(0, 1));
	}

	@Test
	public void testDivision() {
		assertEquals(1, Calculator.div(1.0, 1.0), 0.00000001);
	}

	@Test
	public void testMin() {
		assertEquals(1, Calculator.min(1, 2));
		assertEquals(1, Calculator.min(2, 1));
		assertEquals(-2, Calculator.min(-2, 1));
	}

	@Test
	public void testMax() {
		assertEquals(2, Calculator.max(1, 2));
		assertEquals(2, Calculator.max(2, 1));
		assertEquals(1, Calculator.max(-2, 1));
	}
}
