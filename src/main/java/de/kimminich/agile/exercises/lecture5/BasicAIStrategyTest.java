package de.kimminich.agile.exercises.lecture5;

import de.kimminich.agile.exercises.lecture2.Player;
import de.kimminich.agile.exercises.lecture3.ICardChooserStrategy;
import org.junit.Test;

import static de.kimminich.agile.exercises.lecture5.helper.PlayerHelper.putCardsInHandOf;
import static de.kimminich.agile.exercises.lecture5.helper.PlayerHelper.simulatePlayingCard;
import static org.junit.Assert.assertEquals;

public class BasicAIStrategyTest {

    ICardChooserStrategy strategy = (player, opponent) -> null; // TODO Instantiate implementation to be tested instead

    @Test
    public void shouldDealAsMuchDamageAsPossiblePerRound() {
        Player player = new Player();
        player.setMana(6);
        putCardsInHandOf(player, 1, 2, 2, 3, 4);

        Player opponent = new Player();
        opponent.setLife(10);

        Integer cardToPlay;
        while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null) {
            simulatePlayingCard(player, cardToPlay);
        }

        assertEquals(4, opponent.getLife());
    }

}
