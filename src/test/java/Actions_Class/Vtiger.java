package Actions_Class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Vtiger {
	
	@Test
	public void printMob() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.vtiger.com");
		WebElement company = driver.findElement(By.xpath("//a[contains(text(),'Company')]"));
		//Adding Explicite Wait
		WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(company));
		//Action Class 
		Actions act= new Actions(driver);
		act.moveToElement(company).build().perform();
		driver.findElement(By.partialLinkText("Contact Us")).click();
		//Scroll to Element
		WebElement Bangalore = driver.findElement(By.xpath("(//p[contains(text(),'Bengaluru, India')]/..//p)[last()]"));
		act.scrollToElement(Bangalore).build().perform();
		Thread.sleep(5000);
		String number = Bangalore.getText();
		System.out.println(number);
		//Scrolling till last
		act.scrollToElement(driver.findElement(By.xpath("//a[contains(text(),'Contact Sales')]"))).build().perform();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
