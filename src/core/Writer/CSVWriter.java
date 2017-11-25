package core.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CSVWriter implements BasicWriter {
	private String outputPath;
	private BufferedWriter writer = null;
	private String encoding = "utf-8";
	public CSVWriter(String filePath){
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(filePath)), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public CSVWriter(String filePath,String encoding) {
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(filePath)), encoding));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void write(String str) {
		// TODO Auto-generated method stub
		try {
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
