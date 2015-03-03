package de.kimminich.agile.solutions.lecture6.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    FizzBuzz fb;

    @Before
    public void setup() {
        fb = new FizzBuzz();
    }

    @Test
    public void testNonDividableByThreeOrFiveIsPrintedAsNumber() {
        assertEquals("1", fb.process(1));
        assertEquals("2", fb.process(2));
        assertEquals("4", fb.process(4));
        assertEquals("7", fb.process(7));
        assertEquals("11", fb.process(11));
        assertEquals("98", fb.process(98));
    }

    @Test
    public void testDividableByThreeIsPrintedAsFizz() {
        assertEquals("Fizz", fb.process(3));
        assertEquals("Fizz", fb.process(9));
        assertEquals("Fizz", fb.process(12));
        assertEquals("Fizz", fb.process(18));
        assertEquals("Fizz", fb.process(21));
        assertEquals("Fizz", fb.process(99));
    }

    @Test
    public void testDividableByFiveIsPrintedAsBuzz() {
        assertEquals("Buzz", fb.process(5));
        assertEquals("Buzz", fb.process(10));
        assertEquals("Buzz", fb.process(20));
        assertEquals("Buzz", fb.process(25));
        assertEquals("Buzz", fb.process(35));
        assertEquals("Buzz", fb.process(100));
    }

    @Test
    public void testDividableByThreeAndFiveIsPrintedAsFizzBuzz() {
        assertEquals("FizzBuzz", fb.process(15));
        assertEquals("FizzBuzz", fb.process(30));
        assertEquals("FizzBuzz", fb.process(45));
        assertEquals("FizzBuzz", fb.process(60));
        assertEquals("FizzBuzz", fb.process(75));
        assertEquals("FizzBuzz", fb.process(90));
    }

}
