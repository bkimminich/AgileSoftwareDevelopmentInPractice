package de.kimminich.agile.samplesolutions.excercise6;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.kimminich.agile.excercises.excercise6.Hand;
import de.kimminich.agile.excercises.excercise6.HandCategory;

public class HandSampleImpl extends Hand {

	protected int[] cards;

	public HandSampleImpl(int... cards) {
		this.cards = cards;

		checkCardsRange();
		CardGroups groups = getMapOfCardGroups();
		checkImpossibleNumberOfSameCardValue(groups);

		for (Integer card : groups.keySet()) {
			if (card < 2 || card > 14) {
				throw new IllegalArgumentException("Illegal card value: " + card);
			}
		}
	}

	private void checkImpossibleNumberOfSameCardValue(Map<Integer, Integer> groups) {
		if (groups.values().contains(5)) {
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

	private boolean checkIfStraight() {
		Arrays.sort(cards);
		for (int i = 1; i < cards.length; i++) {
			if (!isCardSuccessorOfPreviousCard(i)) {
				return false;
			}
		}
		return true;
	}

	private boolean isCardSuccessorOfPreviousCard(int i) {
		return cards[i] - cards[i - 1] == 1;
	}

	@Override
	public int compareTo(Hand other) {
		return getHandCategory().compareTo(other.getHandCategory());
	}

	private boolean checkIfFourOfAKind() {
		CardGroups groupsOfCars = getMapOfCardGroups();
		for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {
			if (group.getValue() == 4) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfThreeOfAKind() {
		CardGroups groupsOfCars = getMapOfCardGroups();
		for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {
			if (group.getValue() == 3) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfOnePair() {
		CardGroups groupsOfCars = getMapOfCardGroups();
		for (Entry<Integer, Integer> group : groupsOfCars.entrySet()) {
			if (group.getValue() == 2) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfTwoPair() {
		CardGroups groupsOfCars = getMapOfCardGroups();
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
		CardGroups groupsOfCars = getMapOfCardGroups();
		Collection<Integer> values = groupsOfCars.values();
		return values.contains(2) && values.contains(3);
	}

	private CardGroups getMapOfCardGroups() {
		CardGroups groupsOfCars = new CardGroups();
		for (int card : cards) {
			if (groupsOfCars.get(card) == null) {
				groupsOfCars.put(card, 1);
			} else {
				groupsOfCars.put(card, groupsOfCars.get(card) + 1);
			}
		}
		return groupsOfCars;
	}

	private class CardGroups extends HashMap<Integer, Integer> {

	}

}
