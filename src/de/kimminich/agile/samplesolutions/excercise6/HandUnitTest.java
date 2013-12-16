package de.kimminich.agile.samplesolutions.excercise6;

import de.kimminich.agile.excercises.excercise6.Hand;
import de.kimminich.agile.excercises.excercise6.HandCategory;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static de.kimminich.agile.excercises.excercise6.Hand.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class HandUnitTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldDetermineHighCard() {
        assertThat(aHandWithCards(2, 3, 4, 5, 7), hasCategory(HandCategory.HighCard));
    }

    @Test
    public void shouldDetermineOnePair() {
        assertThat(aHandWithCards(2, 2, 3, 4, 5), hasCategory(HandCategory.OnePair));
    }

    @Test
    public void shouldDetermineThreeOfAKind() {
        assertThat(aHandWithCards(2, 2, 2, 3, 4), hasCategory(HandCategory.ThreeOfAKind));
    }

    @Test
    public void shouldDetermineFourOfAKind() {
        assertThat(aHandWithCards(2, 3, 3, 3, 3), hasCategory(HandCategory.FourOfAKind));
    }

    @Test
    public void shouldDetermineFullHouse() {
        assertThat(aHandWithCards(2, 3, 3, 2, 3), hasCategory(HandCategory.FullHouse));
    }

    @Test
    public void shouldDetermineTwoPair() {
        assertThat(aHandWithCards(2, 2, 3, 3, 4), hasCategory(HandCategory.TwoPair));
    }

    @Test
    public void shouldDetermineStraight() {
        assertThat(aHandWithCards(5, 6, 7, 8, 9), hasCategory(HandCategory.Straight));
    }

    @Test
    public void shouldDetermineStraightEndingWithAce() {
        assertThat(aHandWithCards(10, KNAVE, QUEEN, KING, ACE), hasCategory(HandCategory.Straight));
    }

    @Test
    public void shouldDetermineStraightStartingWithAce() {
        assertThat(aHandWithCards(ACE, 2, 3, 4, 5), hasCategory(HandCategory.Straight));
    }

    @Test
    public void shouldFailOnImpossibleNumberOfSameCardValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Impossible number of same card value.");
        aHandWithCards(5, 5, 5, 5, 5);
    }

    @Test
    public void shouldFailOnTooManyCards() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Too many cards: 6");
        aHandWithCards(2, 3, 4, 5, 6, 7);
    }

    @Test
    public void shouldFailOnNotEnoughCards() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Not enough cards: 4");
        aHandWithCards(2, 3, 4, 5);
    }

    @Test
    public void shouldFailOnTooLowCardDeckValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal card value: 1");
        aHandWithCards(1, 5, 5, 5, 5);
    }

    @Test
    public void shouldFailOnTooHighCardDeckValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal card value: 15");
        aHandWithCards(15, 2, 2, 2, 2);
    }

    @Test
    public void shouldOnePairWinOverHighCard() {
        assertThat(aHandWithCards(2, 2, 4, 5, 6), is(greaterThan(aHandWithCards(5, 7, 8, 9, 10))));
    }

    @Test
    public void shouldTwoPairWinOverOnePair() {
        assertThat(aHandWithCards(2, 2, 4, 4, 5), is(greaterThan(aHandWithCards(6, 7, 7, 9, 10))));
    }

    @Test
    public void shouldThreeOfAKindWinOverTwoPair() {
        assertThat(aHandWithCards(2, 2, 2, 4, 5), is(greaterThan(aHandWithCards(6, 7, 7, 8, 8))));
    }

    @Test
    public void shouldStraightWinOverThreeOfAKind() {
        assertThat(aHandWithCards(2, 3, 4, 5, 6), is(greaterThan(aHandWithCards(6, 7, 8, 8, 8))));
    }

    @Test
    public void shouldFullHouseWinOverStraight() {
        assertThat(aHandWithCards(2, 2, 3, 3, 3), is(greaterThan(aHandWithCards(6, 7, 8, 9, 10))));
    }

    @Test
    public void shouldFourOfAKindWinOverFullHouse() {
        assertThat(aHandWithCards(2, 2, 2, 2, 3), is(greaterThan(aHandWithCards(KING, KING, ACE, ACE, ACE))));
    }

    private static Hand aHandWithCards(int... cards) {
        return new HandSampleImpl(cards);
    }

    private static Matcher<Hand> hasCategory(final HandCategory category) {
        return new TypeSafeMatcher<Hand>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Hand should have category ").appendValue(category);
            }

            @Override
            protected void describeMismatchSafely(Hand hand, Description mismatchDescription) {
                mismatchDescription.appendText(" was ").appendValue(hand.getHandCategory());
            }

            @Override
            protected boolean matchesSafely(Hand hand) {
                return hand.getHandCategory().equals(category);
            }

        };

    }

}
