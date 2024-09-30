package ScreenShort;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CaptureScreenShot {

	
	
	@Test
	public void getScreenShot() throws IOException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		//Now Take ScreenShot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		//We have to Store this in one place
		File store= new File("./ScreenShot/first.png");
		//We have to move the file to folder
		FileUtils.copyFile(temp, store);
		Reporter.log("Successfully Captured ScreenShot",true);
		driver.quit();
	}
}
