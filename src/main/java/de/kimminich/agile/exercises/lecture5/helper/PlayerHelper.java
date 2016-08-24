package de.kimminich.agile.exercises.lecture5.helper;

import de.kimminich.agile.exercises.lecture2.Card;
import de.kimminich.agile.exercises.lecture2.Player;

import java.util.Collections;

public class PlayerHelper {

    public static void putCardsInHandOf(Player player, int... cards) {
        for (int c : cards) {
            Card card = new Card(c);
            // player.addCard(card); // TODO
        }
    }

    public static void simulatePlayingCard(Player player, Card cardToPlay) {
        player.setMana(player.getMana() - cardToPlay.getValue());
        // player.removeCard(card); // TODO
    }

    public static int countOccurencesOfCardInHand(Player player, int card) {
        // return Collections.frequency(player.getHand(), new Card(card)); // TODO
        return -1;
    }

    public static int countTotalOccurencesOfCardsInHand(Player player, int... cards) {
        int total = 0;
        for (int c : cards) {
            total += countOccurencesOfCardInHand(player, c);
        }
        return total;
    }

}
