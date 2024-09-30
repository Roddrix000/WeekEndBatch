package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_URL_ActiTime {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/fireflink3/login.do");
		driver.findElement(By.id("username")).sendKeys("manikantha.a@fireflink.com");
		driver.findElement(By.name("pwd")).sendKeys("Password@123");
		driver.findElement(By.id("loginButton")).click();
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
	
}
