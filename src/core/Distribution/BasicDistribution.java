package core.Distribution;

public abstract class BasicDistribution {
	public abstract Object genRandom();
	public abstract Object genRandom(double low, double high);
	public abstract Object genRandom(int low, int high);
	public abstract Object min();
	public abstract Object max();
//	public class param_type
//	{
//		private int[] para1;
//		private double[] para2;
//		public param_type(int[] para1, double[] para2)
//		{
//			this.para1 = para1;
//			this.para2 = para2;
//		}
//	}
}

