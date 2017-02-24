package de.kimminich.agile.solutions.lecture2.tcg;

import java.util.Collections;
import java.util.Random;

/**
 * Created by bjoern.kimminich on 26.02.2016.
 */
public class TCG {

    private Player player = new Player();
    private Player opponent = new Player();

    /**
     * Starts the game
     * @return the winner
     */
    private boolean start() {
        if (new Random().nextBoolean()) {
            Player temp = player;
            player = opponent;
            opponent = temp;
        }

        player.drawNumberOfCards(3);
        opponent.drawNumberOfCards(4);

        // Game loop
        while (player.getHealth() > 0 && opponent.getHealth() > 0) {
            player.drawNumberOfCards(1);
            player.setMaxMana(Math.min(10, player.getMaxMana()+1));
            player.setMana(player.getMaxMana());
            while (player.getMana() >= Collections.min(player.getHand())) {
                UI.showMessage(player.getName() + "'s turn! You have " + player.getMana() + " mana and your opponent has " + opponent.getHealth() + " health.");
                Integer card = UI.selectCardFrom(player.getHand());
                if (card != null) {
                    if (player.getMana() >= card) {
                        // Pay mana, remove card and damage the opponent
                        player.setMana(player.getMana() - card);
                        player.getHand().remove(card);
                        opponent.setHealth(opponent.getHealth() - card);
                    } else {
                        UI.showMessage("You cannot afford to play this card!");
                    }
                } else {
                    break;
                }
            }
            // Switch turn
            Player temp = player;
            player = opponent;
            opponent = temp;
        }
        return player.getHealth() > 0;
    }


    /**
     * Main method
     * @param args
     */
    public static void main(String... args) {
        TCG tcg = new TCG();
        // Run game
        if (tcg.start()) {
            UI.showMessage("Player 1 wins!"); // Player 1 wins
        } else {
            UI.showMessage("Player 2 wins!"); // Player 2 wins
        }

    }

}
