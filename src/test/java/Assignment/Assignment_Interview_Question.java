package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Interview_Question {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement title = driver.findElement(By.xpath("//head[@class='at-element-marker']//title"));
		String tlt = title.getText();
		String url = driver.findElement(By.tagName("link")).getAttribute("href");
		System.out.println("Successfully Fetched Title:"+tlt+" and URL: "+ url);
	//	System.out.println(driver.getPageSource());
		driver.quit();
		
		
	}
	
}
