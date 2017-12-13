package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Field.BasicField;
import core.Field.DateField;
import core.Field.IntegerField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class TestDate {
	public static void main(String[] args) {
		Random random = new Random();
		//Time density parameter
		//            0   1   2   3   4   5   6   7   8  9 10 11 12  13  14 15 16 17 18 19 20 21 22 23
		int arr[] = {100,100,100,100,100,100,100,100,15, 10,8, 4,  3, 3,  4, 10, 15, 15,3, 4, 4,5 ,20,100};
//		DateField dateField = new DateField("20171101100000", "20171203130000", random, arr);
		DateField dateField = new DateField("20171101100000", random, arr);
		dateField.setTimeStyle(DateField.FIXEDINTERVAL_TIME);
		dateField.setFixedInterval(10 * 60 * 1000);
		IntegerField integerField = new IntegerField(random,1,10);
		BasicWriter writer = new CSVWriter("data//RandomTie.csv");
		List<BasicField> list = new ArrayList<BasicField>();
		writer.initWriter();
		integerField.setHead("ID");
		dateField.setHead("Time");
		list.add(integerField);
		list.add(dateField);
//		while(true) {
//			String result = dateField.getData();
//			if(result.equals("bye"))break;
//			System.out.println(result);
//		}
		CSVGenerator generator = new CSVGenerator(writer, list, 100000);
		generator.Generate();
		System.out.println("");
	}
}
