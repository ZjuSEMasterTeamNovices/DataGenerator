package example.DailyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Distribution.BasicDistribution;
import core.Distribution.binomial_Distribution;
import core.Distribution.exponential_Distribution;
import core.Distribution.poisson_Distribution;
import core.Field.BasicField;
import core.Field.IntegerField;
import core.Generator.CSVGenerator;
import core.Writer.BasicWriter;
import core.Writer.CSVWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "data/test.csv";
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
		//ָ���ֲ�����
//		BasicDistribution dis = new exponential_Distribution(0.7);
//		double ran = (double) dis.genRandom();
//		System.out.println(ran);
		//����ֲ�����
//		BasicDistribution dis = new binomial_Distribution(10, 0.5);
//		int ran = (int)dis.genRandom();
//		System.out.println(ran);
		//���ɷֲ�����
//		BasicDistribution dis = new poisson_Distribution(2.2);
//		int ran = (int)dis.genRandom();
//		System.out.println(ran);
	}

}
