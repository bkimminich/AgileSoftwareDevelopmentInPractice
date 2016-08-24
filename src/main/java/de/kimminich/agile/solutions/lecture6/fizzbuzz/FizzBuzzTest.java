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
        assertFizz(fb.process(3));
        assertFizz(fb.process(9));
        assertFizz(fb.process(12));
        assertFizz(fb.process(18));
        assertFizz(fb.process(21));
        assertFizz(fb.process(99));
    }

    @Test
    public void testDividableByFiveIsPrintedAsBuzz() {
        assertBuzz(fb.process(5));
        assertBuzz(fb.process(10));
        assertBuzz(fb.process(20));
        assertBuzz(fb.process(25));
        assertBuzz(fb.process(35));
        assertBuzz(fb.process(100));
    }

    @Test
    public void testDividableByThreeAndFiveIsPrintedAsFizzBuzz() {
        assertFizzBuzz(fb.process(15));
        assertFizzBuzz(fb.process(30));
        assertFizzBuzz(fb.process(45));
        assertFizzBuzz(fb.process(60));
        assertFizzBuzz(fb.process(75));
        assertFizzBuzz(fb.process(90));
    }

    private void assertFizz(String actual) {
        assertEquals("Fizz", actual);
    }

    private void assertBuzz(String actual) {
        assertEquals("Buzz", actual);
    }

    private void assertFizzBuzz(String actual) {
        assertEquals("FizzBuzz", actual);
    }

}
