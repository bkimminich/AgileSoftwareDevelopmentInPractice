namespace de.kimminich.agile.exercises.lecture2
{

	/// <summary>
	/// Created by bjoern.kimminich on 26.02.2016.
	/// </summary>
	public class TCG
	{

		internal Player p1 = new Player(); // Player 1
		internal Player p2 = new Player(); // Player 2

		/// <summary>
		/// Starts the game </summary>
		/// <returns> the winner </returns>
		public virtual bool start()
		{
			Player p = p1; // TODO Randomly pick starting player instead
			// TODO pull initial cards from deck

			// Game loop
			while (p1.Life > 0 && p2.Life > 0)
			{
				// int card = UI.getInput(p.getCards());
				Card card = new Card(-1); // FIXME Dummy card for now!
				p.Mana = p.Mana - card.Value;
				// TODO Reduce other players health
				// p2.setLife(p.getLife() - card);
				// Switch turn
				if (p == p1)
				{
					p = p2;
				}
				else
				{
					p = p1;
				}
			}
			return p1.Life > 0;
		}


		/// <summary>
		/// Main method </summary>
		/// <param name="args"> </param>
		public static void Main(params string[] args)
		{
			TCG tcg = new TCG();
			// Run game
			if (tcg.start())
			{
				UI.getMessage("Player 1 wins!"); // Player 1 wins
			}
			else
			{
				UI.getMessage("Player 2 wins!"); // Player 2 wins
			}

		}

	}

}