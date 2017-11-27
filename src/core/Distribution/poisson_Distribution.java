package core.Distribution;

public class poisson_Distribution extends BasicDistribution{

	double lmd;//泊松分布参数
	
	public poisson_Distribution(double lmd) {
		super();
		this.lmd = lmd;
	}

	@Override
	public Object genRandom() {
		// TODO Auto-generated method stub
		if(lmd<=0)
			throw new IllegalArgumentException("the argument lmd should be non-negative!");
		double m = Math.exp(-lmd);
		double p = 1.0;
		int k = 0;//返回随机数值
		do
		{
			k++;
			p = p*Math.random();
		}while(p>m);
		return k-1;
	}

	@Override
	public Object genRandom(double low, double high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object genRandom(int low, int high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object max() {
		// TODO Auto-generated method stub
		return null;
	}

}
