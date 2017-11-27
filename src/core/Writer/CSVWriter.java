package core.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CSVWriter implements BasicWriter {
	private String outputPath = null;
	private BufferedWriter writer = null;
	private String encoding = "utf-8";

	public CSVWriter(String filePath){
		this.setOutputPath(filePath);
	}
	public CSVWriter(String filePath,String encoding) {
		this.setOutputPath(filePath);
		this.setEncoding(encoding);
	}
	//init the writer,start writing into the file
	@Override
	public void initWriter() {
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(outputPath+".csv")), encoding));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//write sth into the file
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
	//close the writer
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
	public String getOutputPath() {
		return outputPath;
	}
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


}
