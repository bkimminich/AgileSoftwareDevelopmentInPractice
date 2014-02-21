package de.kimminich.agile.examples.lecture7.hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertFalse;

public class CollectionMatcherDemoTest {

    @Test
    public void shouldNotFindNeedleInHaystack() {
        String[] haystack = {"straw", "straw", "straw", "straw"};

        boolean found = false;
        for (String straw : haystack) {
            if (straw.equals("needle")) {
                found = true;
            }
        }
        assertFalse(found);
    }

    @Test
    public void shouldFindNeedleInHaystack() {
        List<String> haystack = Arrays.asList("straw", "straw", "straw", "needle");

        assertThat(haystack, hasItem("needle"));
    }

}
