package de.kimminich.agile.examples.lecture5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldUnitTest {

	@Test
	public void testHelloWorld() {
		String helloWorld = "Hello" + " World!";
		assertEquals("Hello World!", helloWorld);
	}

}
