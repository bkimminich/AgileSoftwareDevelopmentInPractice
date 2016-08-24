namespace de.kimminich.agile.exercises.lecture5
{

	using NUnit.Framework.Constraints;
	using Card = de.kimminich.agile.exercises.lecture2.Card;
	using ICardChooserStrategy = de.kimminich.agile.exercises.lecture3.ICardChooserStrategy;
	using Player = de.kimminich.agile.exercises.lecture2.Player;
	using PlayerHelper = de.kimminich.agile.exercises.lecture5.helper.PlayerHelper;

	[TestFixture]
	public class SuperAIStrategyTest : AssertionHelper
	{

		internal ICardChooserStrategy strategy = (player, opponent) => null; // TODO Instantiate implementation to be tested instead

		/// <summary>
		/// Explanation: Following the "small cards first" strategy (see <seealso cref="SmartAIStrategyTest"/> the player would
		/// play the cards 1, 2 and 4 when at 7 mana with the given hand. But doing so would waste 2 damage in the subsequent
		/// turn at 8 mana, because he would only have the cards 3 and 6 (the card he draws that turn is ignored here). So it
		/// would be smarter to play 3 and 4 instead and save 6 and 2 for the next turn.
		/// 
		/// </summary>
		[Test]
		public void shouldPlayComboThatMaximizesDamageOverTwoTurns()
		{
			Player player = new Player();
			player.Mana = 7;
			PlayerHelper.putCardsInHandOf(player, 1, 2, 3, 4, 6);

			Player opponent = new Player();

			Card cardToPlay;
			while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null)
			{
				PlayerHelper.simulatePlayingCard(player, cardToPlay);
			}

			Assert.AreEqual(1, countOccurencesOfCardInHand(player, 6));
			Assert.AreEqual(1, countOccurencesOfCardInHand(player, 2));
			Assert.AreEqual(0, countTotalOccurencesOfCardsInHand(player, 3, 4));
		}

		[Test]
		public void shouldTakeChancesForNextDrawnCardIntoAccountWhenPlayingCombo()
		{
			// TODO I'm not smart enough to implement this, LOL! Are you? (^_-)
		}

	}

}