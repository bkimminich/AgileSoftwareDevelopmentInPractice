package de.kimminich.agile.exercises.lecture6.poker;


public abstract class Hand implements Comparable<Hand> {

    public static final int KNAVE = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

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
