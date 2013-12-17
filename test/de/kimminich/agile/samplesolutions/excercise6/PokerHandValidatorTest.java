package de.kimminich.agile.samplesolutions.excercise6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PokerHandValidatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldFailOnImpossibleNumberOfSameCardValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Impossible number of same card value.");
        PokerHandValidator.validate(5, 5, 5, 5, 5);
    }

    @Test
    public void shouldFailOnTooManyCards() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Too many cards: 6");
        PokerHandValidator.validate(2, 3, 4, 5, 6, 7);
    }

    @Test
    public void shouldFailOnNotEnoughCards() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Not enough cards: 4");
        PokerHandValidator.validate(2, 3, 4, 5);
    }

    @Test
    public void shouldFailOnTooLowCardDeckValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal card value: 1");
        PokerHandValidator.validate(1, 5, 5, 5, 5);
    }

    @Test
    public void shouldFailOnTooHighCardDeckValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal card value: 15");
        PokerHandValidator.validate(15, 2, 2, 2, 2);
    }
}
