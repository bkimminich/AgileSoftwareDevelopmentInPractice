package de.kimminich.agile.lecture6.poker;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HandImpl extends Hand {

    protected int[] cards;

    public HandImpl(int... cards) {
        this.cards = cards;

        checkCardsRange();

        Map<Integer, Integer> groups = getMapOfCardGroups();

        checkImpossibleNumberOfSameCardValue(groups);

        for (Integer card : groups.keySet()) {
            if (card <= 1 || card >= 15) {
                throw new RuntimeException();
            }
        }
    }

    private void checkImpossibleNumberOfSameCardValue(Map<Integer, Integer> groups) {
        if (groups.values().contains(5)) {
            throw new RuntimeException("Impossible number of same card value.");
        }
    }

    private void checkCardsRange() {
        if (cards.length > 5) {
            throw new RuntimeException("Too many cards.");
        }
        if (cards.length < 5) {
            throw new RuntimeException("Too little cards.");
        }
    }

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

    private boolean checkIfStraight() {
        Arrays.sort(cards);
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] - cards[i - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Hand other) {
        return getHandCategory().compareTo(other.getHandCategory());
    }

    private boolean checkIfFourOfAKind() {
        Map<Integer, Integer> groupsOfCars = getMapOfCardGroups();

        for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {

            if (group.getValue() == 4) {
                return true;
            }

        }
        return false;
    }

    private boolean checkIfThreeOfAKind() {
        Map<Integer, Integer> groupsOfCars = getMapOfCardGroups();

        for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {

            if (group.getValue() == 3) {
                return true;
            }

        }
        return false;
    }

    private boolean checkIfOnePair() {
        Map<Integer, Integer> groupsOfCars = getMapOfCardGroups();

        for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {

            if (group.getValue() == 2) {
                return true;
            }

        }
        return false;
    }

    private boolean checkIfTwoPair() {
        Map<Integer, Integer> groupsOfCars = getMapOfCardGroups();

        Boolean onePair = null;

        for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {

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

    private boolean checkIfFullHouse() {
        Map<Integer, Integer> groupsOfCars = getMapOfCardGroups();

        Collection<Integer> values = groupsOfCars.values();

        return values.contains(2) && values.contains(3);

    }

    private Map<Integer, Integer> getMapOfCardGroups() {
        Map<Integer, Integer> groupsOfCars = new HashMap<>();
        for (int card : cards) {
            if (groupsOfCars.get(card) == null) {
                groupsOfCars.put(card, 1);
            } else {
                groupsOfCars.put(card, groupsOfCars.get(card) + 1);

            }
        }
        return groupsOfCars;
    }

}
