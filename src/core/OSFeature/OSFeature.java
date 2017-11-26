package core.OSFeature;

public abstract class OSFeature {
	protected static OSFeature uniqueObj = null;
	//return the standard file tail
	public abstract String getTail();
	//init the singleton instance

}
