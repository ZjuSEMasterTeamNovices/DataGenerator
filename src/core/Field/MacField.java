package core.Field;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MacField extends BasicCSVField implements BasicField{

	private String SEPARATOR_OF_MAC = ":";
	private ArrayList<String> originOUI;
	private BufferedReader br;
	private Random random;
	//private Integer numOfMAC;

	public MacField(Random random) {
		this.random = random;
		init();
	}

//	public ArrayList<String> getOriginOUI() {
//		return originOUI;
//	}

	private void init() {
		FileReader fr = null;
		try {
			fr = new FileReader(new File("data\\oui.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File open fail!!");
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		originOUI = new ArrayList<>();
		String line = null;
		try {
			while((line = br.readLine())!=null) {
				originOUI.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("readline fail");
		}
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getData() {

		int num = random.nextInt(originOUI.size());

		//System.out.println(num);

		//use a temporary random device to generate inner fields 
		Random r = new Random(num);

		String[] randomMac = {
				String.format("%s", originOUI.get(num).split("-")[0]),
				String.format("%s", originOUI.get(num).split("-")[1]),
				String.format("%s", originOUI.get(num).split("-")[2]),
				String.format("%02x", r.nextInt(0xff)),
				String.format("%02x", r.nextInt(0xff)),
				String.format("%02x", r.nextInt(0xff))
		};
		return String.join(SEPARATOR_OF_MAC, randomMac);
	}
}
