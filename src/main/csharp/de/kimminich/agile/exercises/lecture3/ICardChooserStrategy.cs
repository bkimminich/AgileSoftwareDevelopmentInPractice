namespace de.kimminich.agile.exercises.lecture3
{

	using Card = de.kimminich.agile.exercises.lecture2.Card;
	using Player = de.kimminich.agile.exercises.lecture2.Player;

	/// <summary>
	/// Implementations of this interface can use different strategies to
	/// pick the best card to play for a player. It is meant to be implemented
	/// for UI selection by human players and AI choices alike.
	/// 
	/// Created by bjoern.kimminich on 26.02.2016.
	/// </summary>
	public interface ICardChooserStrategy
	{

		/// <summary>
		/// This methods chooses the best card to play next in a given
		/// situation between two players.
		/// </summary>
		/// <param name="myMana"> the player's currently available mana </param>
		/// <param name="myCards"> the player's cards in hand </param>
		/// <returns> the best card to play next or <code>null</code> when no card can be played </returns>
		Card nextCardToPlay(Player player, Player opponent);

	}

}