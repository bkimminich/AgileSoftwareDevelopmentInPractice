using System;
using System.Windows.Forms;
using Microsoft.VisualBasic;

namespace de.kimminich.agile.exercises.lecture2
{


	public class UI
	{

		public static int? getInput(params int[] cards)
		{
			string sel;
			while (!object.ReferenceEquals((sel = Microsoft.VisualBasic.Interaction.InputBox(null, "Choose a card to play: " + cards)), null))
			{
				if (sel.matches("[0-8]"))
				{
					int? c = Convert.ToInt32(sel);
					if (Arrays.asList(cards).contains(c))
					{
						return c;
					}
					else
					{
						MessageBox.Show(null, "You do not have this card!");
					}
				}
				else
				{
					MessageBox.Show(null, "Invalid input!");
				}
			}
			return null;
		}

		public static void getMessage(string s)
		{
			MessageBox.Show(null, s);
		}

	}
}