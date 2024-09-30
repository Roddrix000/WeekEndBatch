package Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handeling_JavaScrip_PopUp {

	public static void main(String[] args) {
		
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demoapps.qspiders.com/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		d.findElement(By.linkText("Quick Start")).click();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(3));
		WebElement popUps = d.findElement(By.xpath("//section[text()='Popups']/.."));
		wait.until(ExpectedConditions.visibilityOf(popUps)).click();
		d.findElement(By.linkText("Javascript")).click();
		wait.until(ExpectedConditions.visibilityOf(d.findElement(By.id("buttonAlert2")))).click();
		//Handeling Java Script 
		Alert a= d.switchTo().alert();
		a.accept();
		d.quit();
	}
}
