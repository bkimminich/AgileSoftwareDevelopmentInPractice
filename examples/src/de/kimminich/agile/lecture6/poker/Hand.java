package de.kimminich.agile.lecture6.poker;


public abstract class Hand implements Comparable<Hand> {
	
	protected int[] cards;
	
	public Hand(int... cards) {
		this.cards = cards;
	}

	public abstract HandCategory getHandCategory();

	@Override
	public int compareTo(Hand other) {
		return getHandCategory().compareTo(other.getHandCategory());
	}
	
}
