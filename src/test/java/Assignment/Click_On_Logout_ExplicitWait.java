package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click_On_Logout_ExplicitWait {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.manage().window().maximize();
	driver.get("https://online.actitime.com/fireflink3/login.do");
	driver.findElement(By.id("username")).sendKeys("manikantha.a@fireflink.com");
	driver.findElement(By.name("pwd")).sendKeys("Password@123");
	WebElement logoutBtn = driver.findElement(By.id("loginButton"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.visibilityOf(logoutBtn));
	logoutBtn.click();
	driver.quit();
}
}
