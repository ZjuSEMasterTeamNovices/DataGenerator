package core.Distribution;

public class binomial_Distribution extends BasicDistribution{

	private int n;//进行随机试验的次数
	private double p;//实验事件发生的概率
	
	public binomial_Distribution(int n, double p) {
		this.n = n;
		this.p = p;
	}

	@Override
	public Object genRandom() {
		// TODO Auto-generated method stub
		if(p>1 || p<0 || n<1)
			throw new IllegalArgumentException("wrong arguments!");
		double r;//均匀随机分布产生的随机数
		int x = 0;
		for(int i=0; i<n; i++)
		{
			r = Math.random();
			if(r<p) x++;
		}
		return x;
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
