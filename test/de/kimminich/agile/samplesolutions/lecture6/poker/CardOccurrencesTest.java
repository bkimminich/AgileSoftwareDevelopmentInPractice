package de.kimminich.agile.samplesolutions.lecture6.poker;

import de.kimminich.agile.samplesolutions.lecture6.poker.CardOccurrences;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CardOccurrencesTest {

    CardOccurrences cardOccurrences;

    @Test
    public void shouldRetrieveCorrectCardTypes() {
        cardOccurrences = new CardOccurrences(new int[]{2,2,2,2,2});
        assertThat(cardOccurrences.cardTypes(), hasItems(2));

        cardOccurrences = new CardOccurrences(new int[]{2,2,2,3,4});
        assertThat(cardOccurrences.cardTypes(), hasItems(2, 3, 4));

        cardOccurrences = new CardOccurrences(new int[]{2,3,4,5,6});
        assertThat(cardOccurrences.cardTypes(), hasItems(2, 3, 4, 5, 6));
    }

    @Test
    public void shouldRetrieveCorrectCardOccurrences() {
        cardOccurrences = new CardOccurrences(new int[]{2,2,2,2,2});
        assertThat(cardOccurrences.cardOccurrences(), hasItems(5));

        cardOccurrences = new CardOccurrences(new int[]{2,2,2,3,4});
        assertThat(cardOccurrences.cardOccurrences(), hasItems(3,1,1));

        cardOccurrences = new CardOccurrences(new int[]{2,3,4,5,6});
        assertThat(cardOccurrences.cardOccurrences(), hasItems(1,1,1,1,1));
    }

}
