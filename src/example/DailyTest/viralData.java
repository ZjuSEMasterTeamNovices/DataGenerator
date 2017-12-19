package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Field.BasicField;
import core.Field.DateField;
import core.Field.IntegerField;
import core.Field.MacField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class viralData {
	public static void main(String[] args) {
		Random r = new Random();
		Random AP_Random = new Random();
		IntegerField AP_ID = new IntegerField(AP_Random, 1, 11);
		Random DataRandom = new Random();
		//the params of Population density of per hour
		int arr[] = {-1,-1,-1,-1,-1,-1,-1,-1,150,60,8,4,3,3,4,10,60,150,30,40,40,50,2000,-1};
		DateField dateField = new DateField("20171001000000", "20221001235959", DataRandom, arr);
		AP_ID.setHead("AP_ID");
		dateField.setHead("Time");

		int randomInt = r.nextInt();
		Random MacRandom = new Random(randomInt);
		//Random MacID = new Random(randomInt);
		MacField macField = new MacField(MacRandom);
		//IntegerField MacIdInt = new IntegerField(MacID, 0, macField.getOriginOUI().size());
		macField.setHead("MAC Address");

		BasicWriter writer = new CSVWriter("data//viralData.csv");
		List<BasicField> dataList = new ArrayList<BasicField>();
		dataList.add(AP_ID);
		dataList.add(macField);
		dataList.add(dateField);
		writer.initWriter();
		CSVGenerator generator = new CSVGenerator(writer, dataList, 1000000);
		generator.Generate();
		System.out.println("Process complete");
	}
}
