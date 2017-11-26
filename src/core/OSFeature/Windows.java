package core.OSFeature;

public class Windows extends OSFeature{

	//get the unique instance
	public static OSFeature getInstance() {
		if(uniqueObj == null)
		{
			uniqueObj = new Windows();
		}
		return uniqueObj;
	}

	//Can not instantiate
	private Windows() {
	}

	//return the tail field in Windows
	@Override
	public String getTail() {
		return "\r\n";
	}

}
