package de.kimminich.agile.samplesolutions.lecture6.poker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CardOccurrences {

    private Map<Integer, Integer> tuples = new HashMap<>();

    public CardOccurrences(int[] cards) {
        for (int card : cards) {
            addCard(card);
        }
    }

    private void addCard(int card) {
        if (tuples.get(card) == null) {
            tuples.put(card, 1);
        } else {
            tuples.put(card, tuples.get(card) + 1);
        }
    }

    public Set<Integer> cardTypes() {
        return tuples.keySet();
    }

    public Collection<Integer> cardOccurrences() {
        return tuples.values();
    }

}
