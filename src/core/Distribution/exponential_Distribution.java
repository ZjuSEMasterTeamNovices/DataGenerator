package core.Distribution;

import java.util.Random;

public class exponential_Distribution extends BasicDistribution
{
	private double k;//ָ���ֲ��Ħ�ֵ

	public exponential_Distribution(Random device)
	{
		this.device = device;
	}

	public exponential_Distribution(Random device,double k)
	{
		this.device = device;
		this.k = k;
	}

	@Override
	public double nextValue() {
		if(k<=0)
			throw new IllegalArgumentException("the argument k should be non-negative!");
		double y, z;//zΪ���Ͼ��ȷֲ����������y������ָ���ֲ��������
		z = device.nextDouble();
		y = -(1/k)*Math.log(z);

		return y;
	}

}
