package de.kimminich.agile.demos.lecture5;

public class CalculatorImpl implements Calculator {

    public static void main(String... args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println("1 + 2 = " + calculator.sum(1, 2));
        System.out.println("Min of 1 and 2 = " + calculator.min(1, 2));
        System.out.println("Max of 1 and 2 = " + calculator.max(1, 2));
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }

    public int max(int a, int b) {
        return Math.max(a, Math.abs(b)); // Intentional bug in the implementation that is *missed* by the sample solution unit test!
    }

}