package de.kimminich.agile.examples.lecture5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldUnitTest {

    @Test
    public void testHelloWorld() {
        String helloWorld = "Hello" + " World!";
        assertEquals("Hello World!", helloWorld);
    }

}
