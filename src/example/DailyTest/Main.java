package example.DailyTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import core.Field.BasicCSVField;
import core.Field.BasicField;
import core.Field.IntegerField;
import core.Field.MacField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:\\WorkingSpace\\test.csv";
		Random random = new Random();
		IntegerField int1 = new IntegerField(random,-50,50);
		int1.setHead("TestHead1");
		IntegerField int2 = new IntegerField(random, 100, 500);
		int2.setHead("TestHead2");
		List<BasicField> arr = new ArrayList<BasicField>();
		arr.add(int1);
		arr.add(int2);
		BasicWriter writer = new CSVWriter(filePath);
		writer.initWriter();
		CSVGenerator generator = new CSVGenerator(writer, arr, 100);
		generator.Generate();

	}
	@Test
	public void test() throws IOException {
		MacField randomMac = new MacField();
		for(int i=0;i<100;i++) {
			System.out.println(randomMac.randomMac());
		}
	}

}
