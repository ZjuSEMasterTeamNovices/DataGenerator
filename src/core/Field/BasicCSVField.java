package core.Field;

public abstract class BasicCSVField{
	//the headline of csv file
	private String head = null;
	public void setHead(String head)
	{
		this.head = head;
	}
	public String getHead()
	{
		return head;
	}
}
