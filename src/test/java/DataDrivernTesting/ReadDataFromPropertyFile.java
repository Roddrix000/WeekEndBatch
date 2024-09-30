package DataDrivernTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
public static void main(String[] args) throws IOException   {
	
	FileInputStream fs= new FileInputStream("./Data/CommonData.properties");
	Properties ps= new Properties();
	ps.load(fs);
	String url = ps.getProperty("url");
	System.out.println(url);
	
}
	
	
}
