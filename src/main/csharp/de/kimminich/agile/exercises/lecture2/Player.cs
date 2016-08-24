namespace de.kimminich.agile.exercises.lecture2
{

	public class Player
	{

		private int life = 30;
		private int mana = 0;
		// TODO Implement card deck and hand

		public virtual int Life
		{
			get
			{
				return life;
			}
			set
			{
				this.life = value;
			}
		}


		public virtual int Mana
		{
			get
			{
				return mana;
			}
			set
			{
				this.mana = value;
			}
		}

	}

}