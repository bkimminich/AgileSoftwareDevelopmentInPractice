package de.kimminich.agile.exercises.lecture3;

import de.kimminich.agile.exercises.lecture2.Card;
import de.kimminich.agile.exercises.lecture2.Player;

import java.util.List;

/**
 * Implementations of this interface can use different strategies to
 * pick the best card to play for a player. It is meant to be implemented
 * for UI selection by human players and AI choices alike.
 *
 * Created by bjoern.kimminich on 26.02.2016.
 */
public interface ICardChooserStrategy {

    /**
     * This methods chooses the best card to play next in a given
     * situation between two players.
     *
     * @param myMana the player's currently available mana
     * @param myCards the player's cards in hand
     * @return the best card to play next
     */
    Card nextCardToPlay(Player player, Player opponent);

}
