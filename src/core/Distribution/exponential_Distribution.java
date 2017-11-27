package core.Distribution;

public class exponential_Distribution extends BasicDistribution
{
	private double k;//ָ���ֲ��Ħ�ֵ

	public exponential_Distribution(double k) {
		this.k = k;
	}
	
	@Override
	public Object genRandom() {
		if(k<=0)
			throw new IllegalArgumentException("the argument k should be non-negative!");
		// TODO Auto-generated method stub
		double y, z;//zΪ���Ͼ��ȷֲ����������y������ָ���ֲ��������
		z = Math.random();
		y = -(1/k)*Math.log(z);
		
		return y;
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

}
