package de.kimminich.agile.exercises.lecture5.helper;

import de.kimminich.agile.exercises.lecture2.Card;
import de.kimminich.agile.exercises.lecture2.Player;

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

}
