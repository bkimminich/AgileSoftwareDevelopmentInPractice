package de.kimminich.agile.solutions.lecture3.tcg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {

    private static int id = 0;

    private int health = 30;
    private int mana = 0;
    private int maxMana = 0;

    private List<Integer> deck = new ArrayList(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8));
    private List<Integer> hand = new ArrayList<>();
    private String name = "Player " + ++id;

    public Player() {
        Collections.shuffle(deck);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public List<Integer> getDeck() {
        return deck;
    }

    public void drawNumberOfCards(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            hand.add(deck.remove(0));
        }
    }

}
