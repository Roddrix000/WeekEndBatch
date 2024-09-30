package Synchronisation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTime {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://online.actitime.com/fireflink2/login.do");
		driver.findElement(By.name("username")).sendKeys("poojagunashekar1999@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("Password@123" + Keys.ENTER);
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
}
