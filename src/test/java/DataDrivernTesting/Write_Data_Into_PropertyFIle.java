package DataDrivernTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Write_Data_Into_PropertyFIle {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("./Data/CommonData.properties");
		Properties pit= new Properties();
		pit.load(fis);
		String userName = pit.getProperty("un");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String url = pit.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Adding Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement un = driver.findElement(By.id("username"));
		un.sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(pit.getProperty("pwd"));
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2);
		String homeUrl = driver.getCurrentUrl();
		
		FileOutputStream fos= new FileOutputStream("./Data/CommonData.properties");
		pit.store(fos, homeUrl);
		fos.flush();
		fos.close();
		driver.quit();
		
		
	}
	
	
}
