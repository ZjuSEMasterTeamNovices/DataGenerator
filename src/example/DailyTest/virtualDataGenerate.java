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

public class virtualDataGenerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Random AP_Random = new Random();
		IntegerField AP_ID = new IntegerField(AP_Random, 1, 11);
		Random DataRandom = new Random();
		//           0   1  2  3  4  5  6  7  8  9   10 11 12 13 14 15 16 17 18 19 20 21 22 23
		//the params of Population density of per hour
		int arr[] = {-1,-1,-1,-1,-1,-1,-1,-1,20, 20, 30,40,50,60,50,40,20,30,40,50,60,30,-1,-1};
		DateField dateField = new DateField("20171001000000", DataRandom, arr);
		dateField.setTimeStyle(DateField.FIXEDINTERVAL_TIME);
		dateField.setFixedInterval(5 * 60 * 1000);
		AP_ID.setHead("AP_ID");
		dateField.setHead("Time");

		int randomInt = r.nextInt();
		Random MacRandom = new Random(randomInt);
		//Random MacID = new Random(randomInt);
		MacField macField = new MacField(MacRandom);
		//IntegerField MacIdInt = new IntegerField(MacID, 0, macField.getOriginOUI().size());
		macField.setHead("MAC Address");

		BasicWriter writer = new CSVWriter("data//virtualData");
		List<BasicField> dataList = new ArrayList<BasicField>();
		dataList.add(AP_ID);
		dataList.add(macField);
		dataList.add(dateField);
		writer.initWriter();
		CSVGenerator generator = new CSVGenerator(writer, dataList, 10000000);
		generator.Generate();
		System.out.println("Process complete");
	}

}
