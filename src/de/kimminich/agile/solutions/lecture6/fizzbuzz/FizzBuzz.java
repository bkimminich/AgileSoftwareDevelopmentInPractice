package de.kimminich.agile.solutions.lecture6.fizzbuzz;

public class FizzBuzz {

    public String process(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    public static void main(String... args) {
        FizzBuzz fb = new FizzBuzz();
        for (int i=1; i<=100; i++) {
            System.out.println(fb.process(i));
        }
    }
}
