package de.kimminich.agile.exercises.lecture5;

import de.kimminich.agile.exercises.lecture2.Card;
import de.kimminich.agile.exercises.lecture2.Player;
import de.kimminich.agile.exercises.lecture3.ICardChooserStrategy;
import org.junit.Test;

import static de.kimminich.agile.exercises.lecture5.helper.PlayerHelper.*;
import static org.junit.Assert.assertEquals;

public class SuperAIStrategyTest {

    ICardChooserStrategy strategy = (player, opponent) -> null; // TODO Instantiate implementation to be tested instead

    /**
     * Explanation: Following the "small cards first" strategy (see {@link SmartAIStrategyTest} the player would
     * play the cards 1, 2 and 4 when at 7 mana with the given hand. But doing so would waste 2 damage in the subsequent
     * turn at 8 mana, because he would only have the cards 3 and 6 (the card he draws that turn is ignored here). So it
     * would be smarter to play 3 and 4 instead and save 6 and 2 for the next turn.
     **/
    @Test
    public void shouldPlayComboThatMaximizesDamageOverTwoTurns() {
        Player player = new Player();
        player.setMana(7);
        putCardsInHandOf(player, 1, 2, 3, 4, 6);

        Player opponent = new Player();

        Card cardToPlay;
        while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null) {
            simulatePlayingCard(player, cardToPlay);
        }

        assertEquals(1, countOccurencesOfCardInHand(player, 6));
        assertEquals(1, countOccurencesOfCardInHand(player, 2));
        assertEquals(0, countTotalOccurencesOfCardsInHand(player, 3, 4));
    }

    @Test
    public void shouldTakeChancesForNextDrawnCardIntoAccountWhenPlayingCombo() {
        // TODO I'm not smart enough to implement this, LOL! Are you? (^_-)
    }

}
