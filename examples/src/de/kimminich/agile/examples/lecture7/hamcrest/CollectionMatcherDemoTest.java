package de.kimminich.agile.examples.lecture7.hamcrest;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

public class CollectionMatcherDemoTest {

    @Test
    @Ignore
    public void shouldntFindNeedleInHaystack() {
        // when
        String[] haystack = {"straw", "straw", "straw", "straw"};
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
        List<String> haystack = Arrays.asList("straw", "straw", "straw", "needle");
        // then
        assertThat(haystack, hasItem("needle"));

    }

}
