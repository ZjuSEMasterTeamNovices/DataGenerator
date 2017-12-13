package core.Generator;

import java.awt.Container;
import java.util.List;
import java.util.zip.DataFormatException;

import javax.annotation.Generated;

import core.Field.BasicField;
import core.OSFeature.Linux;
import core.OSFeature.OSFeature;
import core.Field.BasicCSVField;
import core.Writer.BasicWriter;

public class CSVGenerator implements BasicGenerator {
	private BasicWriter outputWriter = null;
	private List<BasicField> fieldList = null;
	private int lines = 0;
	private OSFeature osType = Linux.getInstance();
	private boolean hasHead = true;

	private static char[] illegalCharArr = {',','\r','\n'};

	public CSVGenerator()
	{
		//please initialize parameters with setters
	}

	public CSVGenerator(BasicWriter outputWriter, List<BasicField> fieldList, int lines) {
		this.setOutputWriter(outputWriter);
		this.setFieldList(fieldList);
		this.setLines(lines);
	}

	public void Generate()
	{
		if(outputWriter == null ||
				fieldList == null ||
				lines == 0 ||
				osType == null)
		{
			throw new IllegalArgumentException("Please check your parameters");
		}
		Generate(outputWriter, fieldList, lines, osType);
	}

	//check the character
	private boolean isLegal(char ch)
	{
		for(char itemCh : illegalCharArr)
		{
			if(itemCh == ch)
			{
				return false;
			}
		}
		return true;
	}

	//check the data of field if is valid or not
	private boolean checkData(BasicField item)
	{
		String tmpData = item.getData();
		if(tmpData == null)
		{
			return false;
		}
		for(char tmpChar : tmpData.toCharArray())
		{
			if(!isLegal(tmpChar))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void Generate(BasicWriter outputWriter, List<BasicField> fieldList, int lines, OSFeature osType) {
		// TODO Auto-generated method stub
		for(BasicField item : fieldList)
		{
			if(!(item instanceof BasicCSVField))
			{
				throw new IllegalArgumentException("just BasicCSVField can generate CSV file");
			}
		}
		StringBuilder tmpBuilder = new StringBuilder();
		if(hasHead)
		{
			//print the head row
			for(BasicField item : fieldList)
			{
				tmpBuilder.append( ((BasicCSVField)item).getHead() + ",");
			}
			outputWriter.write(tmpBuilder.substring(0, tmpBuilder.length() - 1) + osType.getTail());
		}
		//print the data rows
		for(int count = 0;count < lines;count++)
		{
			StringBuilder InnerBuilder = new StringBuilder();
			for(BasicField itemInner1 : fieldList)
			{
				if(checkData(itemInner1))
				{
					InnerBuilder.append( itemInner1.getData() + "," );
				}
				else
				{
					throw new IllegalArgumentException("The data cannot contain a comma and so on!");
				}
			}
			outputWriter.write(InnerBuilder.substring(0, InnerBuilder.length() - 1) + osType.getTail());
		}
		outputWriter.close();
	}

	public boolean isHasHead() {
		return hasHead;
	}

	public void setHasHead(boolean hasHead) {
		this.hasHead = hasHead;
	}

	public OSFeature getOsType() {
		return osType;
	}

	public void setOsType(OSFeature osType) {
		if(osType == null)
		{
			throw new IllegalArgumentException("Please ensure the os type is not null");
		}
		this.osType = osType;
	}

	public BasicWriter getOutputWriter() {
		return outputWriter;
	}

	public void setOutputWriter(BasicWriter outputWriter) {
		if(outputWriter == null)
		{
			throw new IllegalArgumentException("Please ensure the writer is not null");
		}
		this.outputWriter = outputWriter;
	}

	public List<BasicField> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<BasicField> fieldList) {
		if(fieldList.size() == 0)
		{
			throw new IllegalArgumentException("There is nothing in your field list!");
		}
		this.fieldList = fieldList;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		if(lines < 1)
		{
			throw new IllegalArgumentException("Please ensure the number of lines larger than zero");
		}
		this.lines = lines;
	}
}
