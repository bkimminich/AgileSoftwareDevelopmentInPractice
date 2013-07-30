package de.kimminich.agile.lecture7.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class CombinedMatchersDemoTest {

	@Test
	@Ignore
	public void shouldntFindNeedleInHaystack() {
		// when
		String[] haystack = { "straw", "straw", "straw", "straw" };
		// then
		boolean found = false;
		for (String straw : haystack) {
			if (straw.equals("needle")) {
				found = true;
			}
		}
		assertTrue(found);
	}

	@Test
	public void shouldFindNeedleInHaystack() {
		// when
		List<String> haystack = Arrays.asList("straw", "straw", "straw", "straw");
		// then
		assertThat(haystack, hasItem("needle"));

	}

}
