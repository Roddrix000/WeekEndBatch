package Actions_Class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Example1 {
	
	
	@Test
	public void demoQspider()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=1");
		WebElement drag = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement drop = driver.findElement(By.xpath("//div[text()='Mobile Accessories']/.."));
		
		//Creating object for Actions Class
		
		Actions a= new Actions(driver);
		a.clickAndHold(drag).pause(Duration.ofSeconds(5)).moveToElement(drop).release().build().perform();
		
	}

}
