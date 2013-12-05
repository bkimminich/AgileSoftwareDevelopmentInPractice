package de.kimminich.agile.examples.lecture6.singleassert;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SingleAssertRuleTest {

    @Test
    public void testPatternMatches1() {
        String pattern = "[a-z]*[0-9]?";
        assertTrue("abcde1".matches(pattern));
    }

    @Test
    public void testPatternMatches2() {
        String pattern = "[a-z]*[0-9]?";
        assertTrue("a1".matches(pattern));
        assertTrue("ab1".matches(pattern));
        assertTrue("abc1".matches(pattern));
        assertFalse("abc12".matches(pattern));
    }

    @Test
    public void testPatternMatches3() {
        String pattern = "[a-z]*[0-9]?";
        assertTrue("a1".matches(pattern));
        assertFalse("a12".matches(pattern));
        pattern = "[a-z]?[0-9]*";
        assertTrue("a1".matches(pattern));
        assertTrue("a12".matches(pattern));
        assertFalse("ab12".matches(pattern));
    }

}
