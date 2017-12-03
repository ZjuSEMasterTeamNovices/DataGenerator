package core.Distribution;

import java.util.Random;

public class poisson_Distribution extends BasicDistribution{

	double lmd;//泊松分布参数

	public poisson_Distribution(Random device)
	{
		this.device = device;
	}

	public poisson_Distribution(Random device,double lmd)
	{
		this.device = device;
		this.lmd = lmd;
	}

	@Override
	public double nextValue() {
		// TODO Auto-generated method stub
		if(lmd<=0)
			throw new IllegalArgumentException("the argument lmd should be non-negative!");
		double m = Math.exp(-lmd);
		double p = 1.0;
		int k = 0;//返回随机数值
		do
		{
			k++;
			p = p*device.nextDouble();
		}while(p>m);
		return k-1;
	}

}
