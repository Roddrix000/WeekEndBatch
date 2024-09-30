package Listeners_Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Working_with_Listners.class)
public class Ninjatutorials_InvalidLogin {
	WebDriver driver;
	@Parameters("browser")
	@Test(groups = "Regression")
	public void AInvalidLogin(String browser) throws InterruptedException
	{
		switch (browser) {
		case "chrome":driver= new ChromeDriver();
			break;
		case "edge":driver= new EdgeDriver();
			break;
		case "firefox":driver= new FirefoxDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		Assert.assertEquals(driver.getTitle(),"Your Store");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("jaham45445@inpsur000.com");
		driver.findElement(By.id("input-password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean result = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).isDisplayed();
		Assert.assertTrue(result);
	}
	@Test(groups = "Regression")
	public void close()
	{
		driver.quit();
	}
}
