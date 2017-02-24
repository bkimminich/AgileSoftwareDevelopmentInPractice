package de.kimminich.agile.solutions.lecture3.tcg;

import java.util.Collections;
import java.util.Random;

/**
 * Created by bjoern.kimminich on 26.02.2016.
 */
public class TCG {

    private Player player = new Player();
    private Player opponent = new Player();

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String... args) {
        new TCG().start();
    }

    /**
     * Starts the game
     *
     * @return the winner
     */
    private void start() {
        // Init
        initializePlayers();
        // Play the game
        Player winner = gameLoop();
        UI.showMessage(winner + " wins!"); // Player 1 wins
    }

    private Player gameLoop() {
        while (isAlive(player) && isAlive(opponent)) {
            prepareTurn();
            while (canAffordToPlayCard(player)) {
                UI.showMessage(player.getName() + "'s turn! You have " + player.getMana() + " mana and your opponent has " + opponent.getHealth() + " health.");
                Integer card = UI.selectCardFrom(player.getHand());
                if (card != null) {
                    playCard(card);
                } else {
                    break;
                }
            }
            // Switch turn
            swapPlayers();
        }
        return determineWinner();
    }

    private void playCard(Integer card) {
        if (player.getMana() >= card) {
            // Pay mana, remove card and damage the opponent
            player.setMana(player.getMana() - card);
            player.getHand().remove(card);
            opponent.setHealth(opponent.getHealth() - card);
        } else {
            UI.showMessage("You cannot afford to play this card!");
        }
    }

    private boolean canAffordToPlayCard(Player player) {
        return player.getMana() >= Collections.min(player.getHand());
    }

    private void prepareTurn() {
        if (player.getDeck().size() == 0) { // bleedout rule
            player.setHealth(player.getHealth() - 1);
        } else {
            player.drawNumberOfCards(1);
            if (player.getHand().size() == 6) {
                player.getHand().remove(5); // overload rule
            }
        }
        player.setMaxMana(Math.min(10, player.getMaxMana() + 1));
        player.setMana(player.getMaxMana());
    }

    private void swapPlayers() {
        Player temp = player;
        player = opponent;
        opponent = temp;
    }

    private Player determineWinner() {
        return isAlive(player) ? player : opponent;
    }

    private boolean isAlive(Player player) {
        return player.getHealth() > 0;
    }

    private void initializePlayers() {
        if (new Random().nextBoolean()) {
            swapPlayers();
        }
        player.drawNumberOfCards(3);
        opponent.drawNumberOfCards(4);
    }

}
