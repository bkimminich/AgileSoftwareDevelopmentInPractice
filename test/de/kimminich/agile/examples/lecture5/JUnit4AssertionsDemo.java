package de.kimminich.agile.examples.lecture5;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class JUnit4AssertionsDemo {

    @Test
    public void testBooleanAssertions() {
        assertTrue(true); // Pass
        assertTrue("Abc".matches("[a-z]*")); // Fail
        assertFalse(false); // Would pass but isn't executed due to preceding fail
    }

    @Test
    public void testAssertionsWithMessages() {
        assertTrue(true);
        assertTrue("This should pass so this text will never shop up anywhere", true);
        assertTrue("As this test fails this message will be displayed", false);
    }

    @Test
    public void testEqualsComparisonAssertions() {
        assertEquals(100L, 100L); // Pass
        assertEquals(0, Collections.emptyList().size()); // Pass
        assertEquals("Expected Result", "Actual Result"); // Fail
    }

    @Test
    public void testSameComparisonAssertions() {
        Object o1 = new Object();
        Object o2 = o1;
        assertSame(o1, o2); // Pass
        assertNotSame(o1, new Object()); // Pass
        assertSame(o2, new Object()); // Fail
    }

    @Test
    public void testNullComparisonAssertions() {
        assertNull(null); // Pass
        Object o = null;
        assertNull(o); // Pass
        assertNotNull(o); // Fail
    }

}
