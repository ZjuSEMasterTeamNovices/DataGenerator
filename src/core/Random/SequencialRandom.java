package core.Random;

import java.util.Random;

public class SequencialRandom extends Random{
	//This is not for Random,Just for sequential numbers
	//At present,we just override the nextInt Method
	private long startIndex = 0;
	private long currIndex;

	public SequencialRandom()
	{
		setSeed(0);
	}
	
	//this seed is the start index
	public SequencialRandom(long seed) {
		setSeed(seed);
	}
	
	private void init()
	{
		this.currIndex = startIndex;
	}

	@Override
	public synchronized void setSeed(long seed) {
		//Now this method is to set the start index
		startIndex = seed;
		init();
	}

	@Override
	public int nextInt() {
		return (int)currIndex++;
	}

	@Override
	public int nextInt(int bound) {
		//the method will mod bound
		return nextInt()%bound;
	}
	
}
