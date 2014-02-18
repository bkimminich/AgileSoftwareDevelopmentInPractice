package de.kimminich.agile.solutions.lecture6.poker;

import de.kimminich.agile.exercises.lecture6.poker.Hand;
import de.kimminich.agile.exercises.lecture6.poker.HandCategory;

import java.util.Arrays;

public class PokerHand extends Hand {

    CardOccurrences cardOccurrences;

    public PokerHand(int... cards) {
        this.cards = cards;
        PokerHandValidator.validate(cards);
        cardOccurrences = new CardOccurrences(cards);
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
        return hasCardNumberOfTimesInHand(3);
    }

    private boolean isOnePair() {
        return hasCardNumberOfTimesInHand(2);
    }

    private boolean isFourOfAKind() {
        return hasCardNumberOfTimesInHand(4);
    }

    private boolean hasCardNumberOfTimesInHand(int occurrences) {
        for (Integer occurrence : cardOccurrences.cardOccurrences()) {
            if (occurrence == occurrences) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPair() {
        Boolean onePair = null;
        for (Integer occurrence : cardOccurrences.cardOccurrences()) {
            if (onePair == null) {
                if (occurrence == 2) {
                    onePair = true;
                    continue;
                }
            }
            if (occurrence == 2) {
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

}
