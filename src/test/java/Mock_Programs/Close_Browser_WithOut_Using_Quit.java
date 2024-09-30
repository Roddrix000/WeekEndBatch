package Mock_Programs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Close_Browser_WithOut_Using_Quit {

	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.indeed.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 String parent = driver.getWindowHandle();
		WebElement Job = driver.findElement(By.id("text-input-what"));
		Job.sendKeys("JPMorgan"+Keys.ENTER);
		Thread.sleep(10000);
		Robot rb = new Robot();
		 for(int i=0; i<5; i++) {
			 rb.keyPress(KeyEvent.VK_PAGE_DOWN);
			 rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
		    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement companyName = driver.findElement(By.xpath("//a[contains(@aria-label,'JPMorgan ')]"));
		wait.until(ExpectedConditions.visibilityOf(companyName));
		companyName.click();
		Set<String> instances = driver.getWindowHandles();
		for(String in:instances)
		{
			if(!in.equals(parent))
			{
				driver.switchTo().window(in);
				System.out.println("Successfully Switched "+driver.getTitle());
				driver.close();
				driver.switchTo().window(parent);
			}
		}
		System.out.println("Successfully Switched Back "+ driver.getTitle());
		driver.close();
		System.out.println("Successfully Closed withOut using quit()");
	}
}
