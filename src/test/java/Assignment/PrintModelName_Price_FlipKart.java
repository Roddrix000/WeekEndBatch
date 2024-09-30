package Assignment;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintModelName_Price_FlipKart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Iphone 15 Pro Max"+Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> PhoneName = driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone')]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone')]/../..//div[contains(text(),'Free delivery')]/../../preceding-sibling::div/div[contains(@class,'N')]"));
		for (int i = 1; i <= PhoneName.size(); i++) {
		  String modelName = driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone')])["+i+"]")).getText();
		  String modelPrice=driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone')]/../..//div[contains(text(),'Free delivery')]/../../preceding-sibling::div/div[contains(@class,'N')])["+i+"]")).getText();
		  System.out.println(i+")"+ modelName+"= "+modelPrice);
		
		}
	driver.quit();
	}
}
