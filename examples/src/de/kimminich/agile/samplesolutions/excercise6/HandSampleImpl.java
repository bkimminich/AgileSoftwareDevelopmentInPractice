package de.kimminich.agile.samplesolutions.excercise6;

import de.kimminich.agile.excercises.excercise6.Hand;
import de.kimminich.agile.excercises.excercise6.HandCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class HandSampleImpl extends Hand {

    protected int[] cards;
    CardValueTuples cardValueTuples;

    public HandSampleImpl(int... cards) {
        this.cards = cards;

        checkCardsRange();
        cardValueTuples = determineOccurencesOfCardValues();
        checkImpossibleNumberOfSameCardValue(cardValueTuples);

        for (Integer card : cardValueTuples.keySet()) {
            if (card < 2 || card > ACE) {
                throw new IllegalArgumentException("Illegal card value: " + card);
            }
        }
    }

    private void checkImpossibleNumberOfSameCardValue(CardValueTuples occurences) {
        if (occurences.values().contains(5)) {
            throw new IllegalArgumentException("Impossible number of same card value.");
        }
    }

    private void checkCardsRange() {
        if (cards.length > 5) {
            throw new IllegalArgumentException("Too many cards: " + cards.length);
        }
        if (cards.length < 5) {
            throw new IllegalArgumentException("Not enough cards: " + cards.length);
        }
    }

    @Override
    public HandCategory getHandCategory() {
        if (checkIfFullHouse()) {
            return HandCategory.FullHouse;
        }
        if (checkIfStraight()) {
            return HandCategory.Straight;
        }
        if (checkIfFourOfAKind()) {
            return HandCategory.FourOfAKind;
        }
        if (checkIfThreeOfAKind()) {
            return HandCategory.ThreeOfAKind;
        }
        if (checkIfTwoPair()) {
            return HandCategory.TwoPair;
        }
        if (checkIfOnePair()) {
            return HandCategory.OnePair;
        }
        return HandCategory.HighCard;
    }

    @Override
    public int compareTo(Hand other) {
        return getHandCategory().compareTo(other.getHandCategory());
    }

    private boolean checkIfFullHouse() {
        return checkIfThreeOfAKind() && checkIfOnePair();
    }

    private boolean checkIfThreeOfAKind() {
        return hasCardValueTupleInGivenCards(3);
    }

    private boolean checkIfOnePair() {
        return hasCardValueTupleInGivenCards(2);
    }

    private boolean checkIfFourOfAKind() {
        return hasCardValueTupleInGivenCards(4);
    }

    private boolean hasCardValueTupleInGivenCards(int tupleSize) {
        for (Entry<Integer, Integer> group : cardValueTuples.entrySet()) {
            if (group.getValue() == tupleSize) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfTwoPair() {
        Boolean onePair = null;
        for (Entry<Integer, Integer> group : cardValueTuples.entrySet()) {
            if (onePair == null) {
                if (group.getValue() == 2) {
                    onePair = true;
                    continue;
                }
            }
            if (group.getValue() == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfStraight() {
        Arrays.sort(cards);
        for (int i = 1; i < cards.length; i++) {
            if (!isCardSuccessorOfPreviousCard(i)) {
                return (i == 4 ? isLastCardAceWithFiveAsPredecessor() : false);
            }
        }
        return true;
    }

    private boolean isCardSuccessorOfPreviousCard(int i) {
        return cards[i] - cards[i - 1] == 1;
    }

    private boolean isLastCardAceWithFiveAsPredecessor() {
        return cards[4] == ACE && cards[3] == 5;
    }

    private CardValueTuples determineOccurencesOfCardValues() {
        CardValueTuples tuples = new CardValueTuples();
        for (int card : cards) {
            if (tuples.get(card) == null) {
                tuples.put(card, 1);
            } else {
                tuples.put(card, tuples.get(card) + 1);
            }
        }
        return tuples;
    }

    private class CardValueTuples extends HashMap<Integer, Integer> {

    }

}
