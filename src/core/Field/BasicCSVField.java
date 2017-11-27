package core.Field;

import java.util.Random;

public abstract class BasicCSVField{
	//the headline of csv file
	private String head = null;
	protected Random device = null;
	public void setHead(String head)
	{
		this.head = head;
	}
	public String getHead()
	{
		return head;
	}
}
