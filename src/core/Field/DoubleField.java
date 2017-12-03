package core.Field;

import java.text.DecimalFormat;
import java.util.Random;

public class DoubleField extends BasicCSVField implements BasicField {

	private int lengthAfterDot = 6;
	private double min = 1.0;
	private double max = -1.0;
	private DecimalFormat dFormat = null;

	public DoubleField(Random device,double min,double max) {
		if(min > max)
		{
			throw new IllegalArgumentException("the value of min must less than the value of max");
		}
		this.device = device;
		this.max = max;
		this.min = min;
	}

	@Override
	public String getData() {
		dFormat = new DecimalFormat(generateFormat());
		if(min > max)
		{
			return dFormat.format(device.nextDouble());
		}

		double scale = max - min;
		double newValue = device.nextDouble() * scale + min;

		return dFormat.format(newValue);
	}
	//generate the format String
	private String generateFormat()
	{
		//according the bits of max to adjust the format string
		StringBuilder tmpBuilder = new StringBuilder();
		for(int count = 0;count < Double.toString(max).indexOf(".");count++)
		{
			tmpBuilder.append("#");
		}
		tmpBuilder.append(".");
		for(int count = 0;count < lengthAfterDot;count++)
		{
			tmpBuilder.append('#');
		}
		return tmpBuilder.toString();
	}

	public int getLengthAfterDot() {
		return lengthAfterDot;
	}

	public void setLengthAfterDot(int lengthAfterDot) {
		this.lengthAfterDot = lengthAfterDot;
	}

	//return the left border
	public double min() {
			return min;
	}
	//return the right border
	public double max() {
		return max;
	}
	//return the Random instance
	public Random getDevice() {
		return device;
	}
}
