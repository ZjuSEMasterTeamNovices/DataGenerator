package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Field.BasicField;
import core.Field.IntegerField;
import core.Field.MacField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class MacTest {
	public static void main(String[] args) {
		Random r = new Random();
		int randomNum = r.nextInt();
		Random random1 = new Random(randomNum);
		Random random2 = new Random(randomNum);
		MacField macField = new MacField(random1);


		//IntegerField int1 = new IntegerField(random2,0,macField.getOriginOUI().size());
		BasicWriter writer = new CSVWriter("data//MacTest.csv");
		List<BasicField> arr = new ArrayList<BasicField>();
		writer.initWriter();
		//int1.setHead("	ID	");
		macField.setHead("	MAC	");
		//arr.add(int1);
		arr.add(macField);
		CSVGenerator generator = new CSVGenerator(writer, arr, 1000);
		generator.Generate();
	}
}
