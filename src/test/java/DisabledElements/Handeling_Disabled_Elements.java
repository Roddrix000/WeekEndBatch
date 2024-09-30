package DisabledElements;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Handeling_Disabled_Elements {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//
		WebElement disabledBtb = driver.findElement(By.id("but2"));
		WebElement disabledTxtBox = driver.findElement(By.id("tb2"));
		Actions act= new Actions(driver);
		act.scrollToElement(disabledBtb).build().perform();
		disabledBtb.click();
		act.scrollToElement(disabledTxtBox).build().perform();
		Thread.sleep(1000);
		try {
			disabledTxtBox.sendKeys("Hello");
		} catch (Exception e) {
			System.out.println("Hence the element is disabled we are using JS");
			JavascriptExecutor js=(JavascriptExecutor)driver;//Non primitive Type casting
			js.executeScript("document.getElementById('tb2').value='Roddrix'");
			Thread.sleep(1000);
			js.executeScript("document.getElementById('tb2').value=''");
			Thread.sleep(1000);
			js.executeScript("document.getElementById('tb2').value='Fredrick'");
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(3000);
		}
		driver.quit();
	}
}
