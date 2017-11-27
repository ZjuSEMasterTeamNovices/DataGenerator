package core.Field;

import java.util.Random;

public class IntegerField extends BasicCSVField implements BasicField{

	private int min = 1;
	private int max = -1;
	
	public IntegerField(Random device)
	{
		this.device = device;
	}

	public IntegerField(Random device,int min,int max) {
		if(min > max)
		{
			throw new IllegalArgumentException("the value of min must less than the value of max");
		}
		this.min = min;
		this.max = max;
		this.device = device;
	}

	@Override
	public String getData() {
		//if user dont specify the min and the max,then we just use the default Random range
		if(min > max)
		{
			return Integer.toString(device.nextInt());
		}
		int boundLength = max - min;

		return Integer.toString(device.nextInt(boundLength) + min);
	}
	//return the left border
	public int min() {
		return min;
	}
	//return the right border
	public int max() {
		return max;
	}
	//return the Random instance
	public Random getDevice() {
		return device;
	}
}
