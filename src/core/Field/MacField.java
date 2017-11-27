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
	private Random random;

	public MacField(Random random) {
		this.random = random;
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("init fail!");
		}
	}

	public ArrayList<String> getOriginOUI() {
		return originOUI;
	}

	public void init() throws IOException {
		FileReader fr = new FileReader(new File("data\\oui.txt"));
		br = new BufferedReader(fr);
		originOUI = new ArrayList<>();
		String line = null;
		while((line = br.readLine())!=null) {
			originOUI.add(line);
		}
	}

	@Override
	public String getData() {

		int num = random.nextInt(originOUI.size());

		//System.out.println(num);

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
