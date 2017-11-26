package core.OSFeature;

public class Linux extends OSFeature{

	//Can not instantiate
	private Linux() {
	}

	//get the unique instance
	public static OSFeature getInstance() {
		if(uniqueObj == null)
		{
			uniqueObj = new Linux();
		}
		return uniqueObj;
	}

	//return the tail field in Windows
	@Override
	public String getTail() {
		return "\n";
	}
}
