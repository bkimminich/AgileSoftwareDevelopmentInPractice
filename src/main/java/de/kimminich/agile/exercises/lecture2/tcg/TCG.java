package de.kimminich.agile.exercises.lecture2.tcg;

/**
 * Created by bjoern.kimminich on 26.02.2016.
 */
public class TCG {

    Player p1 = new Player(); // Player 1
    Player p2 = new Player(); // Player 2

    /**
     * Starts the game
     * @return the winner
     */
    public boolean start() {
        Player p = p1; // TODO Randomly pick starting player instead
        // TODO pull initial cards from deck

        // Game loop
        while (p1.getLife() > 0 && p2.getLife() > 0) {
            // int card = UI.getInput(p.getCards());
            int card = 0; // FIXME Dummy card for now!
            p.setMana(p.getMana() - card);
            // TODO Reduce other players health
            // p2.setLife(p.getLife() - card);
            // Switch turn
            if (p == p1) {
                p = p2;
            } else {
                p = p1;
            }
        }
        return p1.getLife() > 0;
    }


    /**
     * Main method
     * @param args
     */
    public static void main(String... args) {
        TCG tcg = new TCG();
        // Run game
        if (tcg.start()) {
            UI.getMessage("Player 1 wins!"); // Player 1 wins
        } else {
            UI.getMessage("Player 2 wins!"); // Player 2 wins
        }

    }

}
