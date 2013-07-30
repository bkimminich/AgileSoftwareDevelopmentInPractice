package de.kimminich.agile.lecture5;

public class Calculator {

	public static void main(String... args) {
		System.out.println("1 + 2 = " + Calculator.sum(1, 2));
		System.out.println("Min von -1 und -2 = " + Calculator.min(-1, -2));
		System.out.println("Max von -1 und -2 = " + Calculator.max(-1, -2));
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
		return Math.max(a, b);
	}

}