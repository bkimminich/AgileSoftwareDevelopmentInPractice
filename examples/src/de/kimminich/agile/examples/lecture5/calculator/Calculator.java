package de.kimminich.agile.examples.lecture5.calculator;

public class Calculator {

	public static void main(String... args) {
		System.out.println("1 + 2 = " + Calculator.sum(1, 2));
		System.out.println("Min of 1 and 2 = " + Calculator.min(1, 2));
		System.out.println("Max of 1 and 2 = " + Calculator.max(1, 2));
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int modulo(int a, int b) {
		return a % b;
	}

	public static double div(Double a, Double b) {
		return a / b;
	}

	public static int min(int a, int b) {
		return Math.min(a, b);
	}

	public static int max(int a, int b) {
		return Math.max(a, Math.abs(b)); // Intentional bug in the implementation
	}

}