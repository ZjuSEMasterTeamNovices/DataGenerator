package core.OSFeature;

public class MacOS extends OSFeature{

	//get the unique instance
	public static OSFeature getInstance() {
		if(uniqueObj == null)
		{
			uniqueObj = new MacOS();
		}
		return uniqueObj;
	}

	//Can not instantiate
	private MacOS() {
	}

	//return the tail field in Windows
	@Override
	public String getTail() {
		return "\r";
	}
}
