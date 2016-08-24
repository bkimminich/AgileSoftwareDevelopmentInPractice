namespace de.kimminich.agile.exercises.lecture5
{

	using NUnit.Framework.Constraints;
	using Card = de.kimminich.agile.exercises.lecture2.Card;
	using ICardChooserStrategy = de.kimminich.agile.exercises.lecture3.ICardChooserStrategy;
	using Player = de.kimminich.agile.exercises.lecture2.Player;
	using PlayerHelper = de.kimminich.agile.exercises.lecture5.helper.PlayerHelper;

	[TestFixture]
	public class BasicAIStrategyTest : AssertionHelper
	{

		internal ICardChooserStrategy strategy = (player, opponent) => null; // TODO Instantiate implementation to be tested instead

		[Test]
		public void shouldDealAsMuchDamageAsPossiblePerRound()
		{
			Player player = new Player();
			player.Mana = 6;
			PlayerHelper.putCardsInHandOf(player, 1, 2, 2, 3, 4);

			Player opponent = new Player();
			opponent.Life = 10;

			Card cardToPlay;
			while ((cardToPlay = strategy.nextCardToPlay(player, opponent)) != null)
			{
				PlayerHelper.simulatePlayingCard(player, cardToPlay);
			}

			Assert.AreEqual(4, opponent.Life);
		}

	}

}