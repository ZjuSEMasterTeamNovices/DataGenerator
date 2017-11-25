package core.Generator;

import java.util.List;

import javax.annotation.Generated;

import core.Field.BasicField;
import core.Writer.BasicWriter;

public interface BasicGenerator {
	public void Generate(BasicWriter outputWriter,List<BasicField> fieldList, int lines);
}
