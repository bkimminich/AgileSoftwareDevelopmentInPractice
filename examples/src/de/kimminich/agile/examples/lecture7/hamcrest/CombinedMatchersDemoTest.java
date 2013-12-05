package de.kimminich.agile.examples.lecture7.hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CombinedMatchersDemoTest {

    @Test
    public void shouldCombineSimpleMatchers() {
        // when
        int result = 2;
        // then
        assertThat(result, is(not(0)));
        assertThat(result, is(both(greaterThan(1)).and(lessThan(3))));
    }

    @Test
    public void shouldCombineCollectionMatchers() {
        // when
        List<Integer> result = Arrays.asList(1, 2);
        // then
        assertThat(result, hasItem(anyOf(equalTo(2), equalTo(3))));
        assertThat(result, not(hasItems(3, 4)));

    }

}
