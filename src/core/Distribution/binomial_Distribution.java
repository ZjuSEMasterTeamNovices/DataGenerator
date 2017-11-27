package core.Distribution;

public class binomial_Distribution extends BasicDistribution{

	private int n;//�����������Ĵ���
	private double p;//ʵ���¼������ĸ���
	
	public binomial_Distribution(int n, double p) {
		this.n = n;
		this.p = p;
	}

	@Override
	public Object genRandom() {
		// TODO Auto-generated method stub
		if(p>1 || p<0 || n<1)
			throw new IllegalArgumentException("wrong arguments!");
		double r;//��������ֲ������������
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
