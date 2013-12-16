package de.kimminich.agile.samplesolutions.excercise6;

import de.kimminich.agile.excercises.excercise6.Hand;
import de.kimminich.agile.excercises.excercise6.HandCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class HandSampleImpl extends Hand {

    CardValueTuples cardValueTuples;

    public HandSampleImpl(int... cards) {
        this.cards = cards;

        checkCardsRange();
        cardValueTuples = countOccurencesOfCardValues();
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
        if (isFullHouse()) {
            return HandCategory.FullHouse;
        }
        if (isStraight()) {
            return HandCategory.Straight;
        }
        if (isFourOfAKind()) {
            return HandCategory.FourOfAKind;
        }
        if (isThreeOfAKind()) {
            return HandCategory.ThreeOfAKind;
        }
        if (isTwoPair()) {
            return HandCategory.TwoPair;
        }
        if (isOnePair()) {
            return HandCategory.OnePair;
        }
        return HandCategory.HighCard;
    }

    private boolean isFullHouse() {
        return isThreeOfAKind() && isOnePair();
    }

    private boolean isThreeOfAKind() {
        return hasCardValueTupleInGivenCards(3);
    }

    private boolean isOnePair() {
        return hasCardValueTupleInGivenCards(2);
    }

    private boolean isFourOfAKind() {
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

    private boolean isTwoPair() {
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

    private boolean isStraight() {
        Arrays.sort(cards);
        for (int i = 1; i < cards.length; i++) {
            if (!isCardSuccessorOfPreviousCard(i)) {
                return isStraightStartingWithAce();
            }
        }
        return true;
    }

    private boolean isCardSuccessorOfPreviousCard(int i) {
        return cards[i] - cards[i - 1] == 1;
    }

    private boolean isStraightStartingWithAce() {
        return Arrays.equals(cards, new int[]{2, 3, 4, 5, ACE});
    }

    private CardValueTuples countOccurencesOfCardValues() {
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

    private static class CardValueTuples extends HashMap<Integer, Integer> {

    }

}
