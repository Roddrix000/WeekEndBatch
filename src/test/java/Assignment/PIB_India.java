package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIB_India {
	
	public static void main(String[] args) {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://pib.gov.in/indexd.aspx");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String ParentWindow = driver.getWindowHandle();
		//Handeling the Javascript alert 
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//Scrolling until Ministry of Defence
		Actions act= new Actions(driver);
		WebElement MOD = driver.findElement(By.partialLinkText("Ministry of Defence"));
		wait.until(ExpectedConditions.elementToBeClickable(MOD));
		act.scrollToElement(MOD);
		wait.until(ExpectedConditions.elementToBeClickable(MOD));
		MOD.click();
		System.out.println(alert.getText());
		alert.accept();
		//Switching to child Window
		Set<String> allWindows = driver.getWindowHandles();
		for(String win:allWindows)
		{
			if(!win.equals(ParentWindow))
			{
				driver.switchTo().window(win);
				System.out.println("Successfully Switched");
			}			
		}
		String ChildWinTitle = driver.getTitle();
		System.out.println(ChildWinTitle);
		driver.quit();
		
	}

}
