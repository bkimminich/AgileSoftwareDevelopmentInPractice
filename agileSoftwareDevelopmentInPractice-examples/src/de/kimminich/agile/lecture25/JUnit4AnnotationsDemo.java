package de.kimminich.agile.lecture25;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit4AnnotationsDemo {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Executed once before the start of all tests");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Executed once after all tests have been finished");
	}

	@Before
	public void before() {
		System.out.println("Executed before each test");
	}

	@After
	public void after() {
		System.out.println("Executed after each test");
	}

	@Before
	public void anotherBefore() {
		System.out.println("Another method executed before each test");
	}

	@Test
	public void test() {
		System.out.println("This is a test that is expected to pass normally");
	}

	@Test(expected = Exception.class)
	public void testException() {
		System.out.println("This test is expected to pass if an Exception occurs");
		int i = 0 / 0;
	}

	@Test(timeout = 1000)
	public void testTimeout() throws Exception {
		System.out.println("This test is expected to pass if it executed faster than 1000ms");
		Thread.sleep(100);
	}

	@Test
	@Ignore
	public void testIgnore() throws Exception {
		System.out.println("This test is ignored and will not be executed");
	}

	public void testForgottenTestAnnotation() {
		System.out.println("This method will not be recognized as a test method");
	}

}
