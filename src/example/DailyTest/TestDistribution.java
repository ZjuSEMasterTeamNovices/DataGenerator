package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Distribution.binomial_Distribution;
import core.Distribution.exponential_Distribution;
import core.Distribution.poisson_Distribution;
import core.Field.BasicField;
import core.Field.IntegerField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class TestDistribution {
	public static void main(String[] args) {
		//this is just a test code,plz dont use it in offical environment
		String filePath = "testDistribution";

		Random random = new Random();
		exponential_Distribution distribution = new exponential_Distribution(random);
		IntegerField int1 = new IntegerField(distribution,-50,50);
		int1.setHead("asd");

		Random random2 = new Random();
		poisson_Distribution distribution2 = new poisson_Distribution(random2);
		IntegerField int2 = new IntegerField(distribution2, 200, 1000);
		int2.setHead("dsa");
		
		List<BasicField> arr = new ArrayList<BasicField>();
		arr.add(int1);
		arr.add(int2);
		BasicWriter writer = new CSVWriter(filePath);
		writer.initWriter();
		CSVGenerator generator = new CSVGenerator(writer, arr, 100);
		generator.Generate();
	}

}
