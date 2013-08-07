package de.kimminich.agile.lecture6.poker;

import org.junit.Test;

import static de.kimminich.agile.lecture6.poker.HandCategory.*;
import static org.junit.Assert.assertEquals;

public class HandTest {

    @Test
    public void shouldBeFourOfAKind() {
        Hand hand = new HandImpl(6, 6, 6, 6, 7);
        assertEquals(FourOfAKind, hand.getHandCategory());
    }

    @Test
    public void shouldBeOnePair() {
        Hand hand = new HandImpl(2, 2, 3, 4, 5);
        assertEquals(OnePair, hand.getHandCategory());
    }

    @Test
    public void shouldBeTwoPair() {
        Hand hand = new HandImpl(2, 2, 3, 5, 5);
        assertEquals(TwoPair, hand.getHandCategory());
    }

    @Test
    public void shouldBeThreeOfAKind() {
        Hand hand = new HandImpl(2, 2, 2, 3, 4);
        assertEquals(ThreeOfAKind, hand.getHandCategory());
    }

    @Test
    public void shouldBeThreeOfAKindStraight() {
        Hand hand = new HandImpl(2, 6, 5, 3, 4);
        assertEquals(Straight, hand.getHandCategory());
    }

    @Test
    public void shouldBeFullHouse() {
        Hand hand = new HandImpl(2, 2, 5, 5, 5);
        assertEquals(FullHouse, hand.getHandCategory());
    }

    @Test
    public void shouldBeHighCard() {
        Hand hand = new HandImpl(2, 3, 4, 5, 7);
        assertEquals(HighCard, hand.getHandCategory());
    }
}
