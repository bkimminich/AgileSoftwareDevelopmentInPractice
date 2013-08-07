package de.kimminich.agile.lecture6.poker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class GenericHandTest {

    private static Hand aHandWithCards(int... cards) {
        return new HandImpl(cards);
    }

    @Test
    public void shouldDetermineHighCardCombo() {
        assertThat(aHandWithCards(2, 3, 4, 5, 7), hasCategory(HandCategory.HighCard));
    }

    @Test
    public void shouldDetermineOnePairCombo() {
        assertThat(aHandWithCards(2, 2, 3, 4, 5), hasCategory(HandCategory.OnePair));
    }

    @Test
    public void shouldDetermineThreeOfAKindCombo() {
        assertThat(aHandWithCards(2, 2, 2, 3, 4), hasCategory(HandCategory.ThreeOfAKind));
    }

    @Test
    public void shouldDetermineFourOfAKindCombo() {
        assertThat(aHandWithCards(2, 3, 3, 3, 3), hasCategory(HandCategory.FourOfAKind));
    }

    @Test
    public void shouldDetermineFullHouseCombo() {
        assertThat(aHandWithCards(2, 3, 3, 2, 3), hasCategory(HandCategory.FullHouse));
    }

    @Test
    public void shouldDetermineTwoPairCombo() {
        assertThat(aHandWithCards(2, 2, 3, 3, 4), hasCategory(HandCategory.TwoPair));
    }

    @Test
    public void shouldDetermineStraightCombo() {
        assertThat(aHandWithCards(5, 6, 7, 8, 9), hasCategory(HandCategory.Straight));
    }

    @Test(expected = Exception.class)
    public void shouldFailOnImpossibleNumberOfSameCardValue() {
        aHandWithCards(5, 5, 5, 5, 5);
    }

    @Test(expected = Exception.class)
    public void shouldFailOnTooManyCards() {
        aHandWithCards(2, 3, 4, 5, 6, 7);
    }

    @Test(expected = Exception.class)
    public void shouldFailOnTooLittleCards() {
        aHandWithCards(2, 3, 4, 5);
    }

    @Test(expected = Exception.class)
    public void shouldFailOnTooLowCardDeckValue() {
        aHandWithCards(1, 5, 5, 5, 5);
    }

    @Test(expected = Exception.class)
    public void shouldFailOnTooHighCardDeckValue() {
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
        assertThat(aHandWithCards(2, 2, 2, 2, 3), is(greaterThan(aHandWithCards(13, 13, 14, 14, 14))));
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
