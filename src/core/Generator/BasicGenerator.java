package core.Generator;

import java.util.List;

import core.Field.BasicField;
import core.OSFeature.OSFeature;
import core.Writer.BasicWriter;

public interface BasicGenerator {
	//according to the parameters to generate the output file
	public void Generate(BasicWriter outputWriter,List<BasicField> fieldList, int lines, OSFeature osType);
}
