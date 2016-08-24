namespace de.kimminich.agile.exercises.lecture2
{

	/// <summary>
	/// The <seealso cref="Card"/> class.
	/// 
	/// @author bjoern.kimminich
	/// </summary>
	public class Card
	{

		private int value;

		public Card(int value)
		{
			this.value = value;
		}

		public virtual int Value
		{
			get
			{
				return value;
			}
		}

	}

}