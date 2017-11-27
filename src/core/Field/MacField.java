package core.Field;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MacField extends BasicCSVField implements BasicField{

	private String SEPARATOR_OF_MAC = ":";
	private ArrayList<String> originOUI;
	private BufferedReader br;

	public void init() throws IOException {
		FileReader fr = new FileReader(new File("data\\oui.txt"));
		br = new BufferedReader(fr);
		originOUI = new ArrayList<>();
		String line = null;
		while((line = br.readLine())!=null) {
			originOUI.add(line);
		}
	}

	public String randomMac() throws IOException {
		init();
		Random random = new Random();
		int num = random.nextInt(originOUI.size());

		String[] randomMac = {

				String.format("%s", originOUI.get(num-1).split("-")[0]),
				String.format("%s", originOUI.get(num-1).split("-")[1]),
				String.format("%s", originOUI.get(num-1).split("-")[2]),
				String.format("%02x", random.nextInt(0xff)),
				String.format("%02x", random.nextInt(0xff)),
				String.format("%02x", random.nextInt(0xff))
		};
		return String.join(SEPARATOR_OF_MAC, randomMac);
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
