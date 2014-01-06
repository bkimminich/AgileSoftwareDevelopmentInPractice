package de.kimminich.agile.solutions.lecture6.poker;

import static de.kimminich.agile.excercises.lecture6.poker.Hand.ACE;

public class PokerHandValidator {

    public static void validate(int... cards) {
        CardOccurrences cardOccurrences = new CardOccurrences(cards);
        checkNumberOfCards(cards);
        checkImpossibleNumberOfSameCardValue(cardOccurrences);
        checkInvalidCardValues(cardOccurrences);
    }

    private static void checkNumberOfCards(int[] cards) {
        if (cards.length > 5) {
            throw new IllegalArgumentException("Too many cards: " + cards.length);
        }
        if (cards.length < 5) {
            throw new IllegalArgumentException("Not enough cards: " + cards.length);
        }
    }

    private static void checkImpossibleNumberOfSameCardValue(CardOccurrences cardOccurrences) {
        if (cardOccurrences.cardOccurrences().contains(5)) {
            throw new IllegalArgumentException("Impossible number of same card value.");
        }
    }

    private static void checkInvalidCardValues(CardOccurrences cardOccurrences) {
        for (Integer card : cardOccurrences.cardTypes()) {
            if (card < 2 || card > ACE) {
                throw new IllegalArgumentException("Illegal card value: " + card);
            }
        }
    }
}
