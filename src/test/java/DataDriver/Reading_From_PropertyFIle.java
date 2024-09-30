package DataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reading_From_PropertyFIle {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("./Data/CommonData1.properties");
		Properties p = new Properties();
		p.load(fis);
		String name = p.getProperty("Name");
		System.out.println(name);
		
		
	}
}
