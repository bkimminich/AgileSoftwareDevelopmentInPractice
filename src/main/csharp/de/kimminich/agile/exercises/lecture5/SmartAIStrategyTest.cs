namespace de.kimminich.agile.exercises.lecture5
{

	using NUnit.Framework.Constraints;
	using Card = de.kimminich.agile.exercises.lecture2.Card;
	using ICardChooserStrategy = de.kimminich.agile.exercises.lecture3.ICardChooserStrategy;
	using Player = de.kimminich.agile.exercises.lecture2.Player;
	using PlayerHelper = de.kimminich.agile.exercises.lecture5.helper.PlayerHelper;

	[TestFixture]
	public class SmartAIStrategyTest : AssertionHelper
	{

		internal ICardChooserStrategy strategy = (player, opponent) => null; // TODO Instantiate implementation to be tested instead

		[Test]
		public void shouldNotKeepAnyZeroCardsInHand()
		{
			Player player = new Player();
			PlayerHelper.putCardsInHandOf(player, 0, 0, 1, 2, 3);

			Player opponent = new Player();

			Card cardToPlay;
			while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null)
			{
				PlayerHelper.simulatePlayingCard(player, cardToPlay);
			}

			Assert.AreEqual(0, countOccurencesOfCardInHand(player, 0));
		}

		[Test]
		public void shouldPreferToPlayMultipleLowCardsOverSingleHighCardToPreventOverload()
		{
			Player player = new Player();
			player.Mana = 7;
			PlayerHelper.putCardsInHandOf(player, 1, 2, 4, 7, 6);

			Player opponent = new Player();

			Card cardToPlay;
			while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null)
			{
				PlayerHelper.simulatePlayingCard(player, cardToPlay);
			}

			Assert.AreEqual(1, countOccurencesOfCardInHand(player, 7));
			Assert.AreEqual(1, countOccurencesOfCardInHand(player, 6));
			Assert.AreEqual(0, countTotalOccurencesOfCardsInHand(player, 1, 2, 4));
		}

	}

}