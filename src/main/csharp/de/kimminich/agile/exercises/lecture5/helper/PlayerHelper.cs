namespace de.kimminich.agile.exercises.lecture5.helper
{

	using Card = de.kimminich.agile.exercises.lecture2.Card;
	using Player = de.kimminich.agile.exercises.lecture2.Player;

	public static class PlayerHelper
	{

		public static void putCardsInHandOf(Player player, params int[] cards)
		{
			foreach (int c in cards)
			{
				Card card = new Card(c);
				// player.addCard(card); // TODO
			}
		}

		public static void simulatePlayingCard(Player player, Card cardToPlay)
		{
			player.Mana = player.Mana - cardToPlay.Value;
			// player.removeCard(card); // TODO
		}

		public static int countOccurencesOfCardInHand(Player player, int card)
		{
			// return Collections.frequency(player.getHand(), new Card(card)); // TODO
			return -1;
		}

		public static int countTotalOccurencesOfCardsInHand(Player player, params int[] cards)
		{
			int total = 0;
			foreach (int c in cards)
			{
				total += countOccurencesOfCardInHand(player, c);
			}
			return total;
		}

	}

}