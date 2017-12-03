package core.Distribution;

import java.util.Random;

public class binomial_Distribution extends BasicDistribution{

	private int n = 1000;//进行随机试验的次数
	private double p = 0.5;//实验事件发生的概率

	public binomial_Distribution(Random device)
	{
		this.device = device;
	}

	public binomial_Distribution(Random device, int n, double p) {
		this.device = device;
		this.n = n;
		this.p = p;
	}

	@Override
	public double nextValue() {
		if(p>1 || p<0 || n<1)
			throw new IllegalArgumentException("wrong arguments!");
		double r;//均匀随机分布产生的随机数
		int x = 0;
		for(int i=0; i<n; i++)
		{
			r = device.nextDouble();
			if(r<p) x++;
		}
		return x;
	}

}
