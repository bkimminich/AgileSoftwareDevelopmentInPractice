package de.kimminich.agile.lecture7.singleassert;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

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
