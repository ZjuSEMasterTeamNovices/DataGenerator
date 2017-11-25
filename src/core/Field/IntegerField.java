package core.Field;

import java.util.Random;

public class IntegerField implements BasicCSVField {
	private int min = 1;
	private int max = -1;
	private Random device;
	private String head = null;

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
	public void setHead(String head) {
		this.head = head;
	}

	@Override
	public String getData() {
		if(min > max)
		{
			return Integer.toString(device.nextInt());
		}
		int boundLength = max - min;

		return Integer.toString(device.nextInt(boundLength) + min);
	}

	@Override
	public String getHead() {
		return this.head;
	}

}
