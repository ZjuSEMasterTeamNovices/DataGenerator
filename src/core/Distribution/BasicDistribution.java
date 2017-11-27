package core.Distribution;

import java.util.Random;

public abstract class BasicDistribution extends Random{
	//Plz dont use this class and its subclass before we finish them all
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected Random device = null;

	protected int min = 1;
	protected int max = -1;

	public int min()
	{
		return this.min;
	}
	public int max()
	{
		return this.max;
	}

	//if you just require the integer type and set the borders correctly,plz convert the
	//output value to integer
	//To Developer:plz ensure your output satisfy the requirements of borders and the style
	//of distribution
	public abstract double nextValue();
}

