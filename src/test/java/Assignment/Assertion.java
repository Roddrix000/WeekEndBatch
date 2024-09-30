package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	public String emailid = "";
	public String password = "Password@123";

	@Test
	public void logintotutorialNonja() {
		
		//Adding Soft Assert
		SoftAssert softassert= new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Adding implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		// Hard Assert
		System.out.println(driver.getTitle());
		softassert.assertTrue(driver.getTitle().equals("Your Storeadasdsc"), "MissMatch in Title");

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		// Hard Assert
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]")).isDisplayed());

		driver.findElement(By.name("email")).sendKeys("jaham45445@inpsur.com");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.quit();
		softassert.assertAll();
	}
}
