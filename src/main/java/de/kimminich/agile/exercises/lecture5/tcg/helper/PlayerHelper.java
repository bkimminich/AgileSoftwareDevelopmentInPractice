package de.kimminich.agile.exercises.lecture5.tcg.helper;

import de.kimminich.agile.exercises.lecture2.tcg.Player;

public class PlayerHelper {

    public static void putCardsInHandOf(Player player, int... cards) {
        for (int i = 0; i < cards.length; i++) {
            // player.addCard(card); // TODO
        }
    }

    public static void simulatePlayingCard(Player player, Integer cardToPlay) {
        player.setMana(player.getMana() - cardToPlay);
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
