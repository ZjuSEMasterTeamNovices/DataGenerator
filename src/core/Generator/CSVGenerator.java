package core.Generator;

import java.util.List;

import core.Field.BasicField;
import core.Field.BasicCSVField;
import core.Writer.BasicWriter;

public class CSVGenerator implements BasicGenerator {

	@Override
	public void Generate(BasicWriter outputWriter, List<BasicField> fieldList, int lines) {
		// TODO Auto-generated method stub
		for(BasicField item : fieldList)
		{
			if(!(item instanceof BasicCSVField))
			{
				throw new IllegalArgumentException("just BasicCSVField can generate CSV file");
			}
		}
		StringBuilder tmpBuilder = new StringBuilder();
		for(BasicField item : fieldList)
		{
			tmpBuilder.append( ((BasicCSVField)item).getHead() + ",");
		}
		outputWriter.write(tmpBuilder.substring(0, tmpBuilder.length() - 1) + "\n");
		for(int count = 0;count < lines;count++)
		{
			StringBuilder InnerBuilder = new StringBuilder();
			for(BasicField itemInner1 : fieldList)
			{
				InnerBuilder.append( ((BasicCSVField)itemInner1).getData() + "," );
			}
			outputWriter.write(InnerBuilder.substring(0, InnerBuilder.length() - 1) + "\n");
		}
		outputWriter.close();
	}
}
