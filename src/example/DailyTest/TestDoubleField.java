package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Field.BasicField;
import core.Field.DoubleField;
import core.Field.IntegerField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class TestDoubleField {

	public static void main(String[] args) {
		String filePath = "testDouble";
		Random random = new Random();
		DoubleField double1 = new DoubleField(random, 500, 1000);
		DoubleField double2 = new DoubleField(random, -5.0, 20.0);
		List<BasicField> arr = new ArrayList<BasicField>();
		arr.add(double1);
		arr.add(double2);
		BasicWriter writer = new CSVWriter(filePath);
		writer.initWriter();
		CSVGenerator generator = new CSVGenerator(writer, arr, 100);
		generator.Generate();
		
	}

}
