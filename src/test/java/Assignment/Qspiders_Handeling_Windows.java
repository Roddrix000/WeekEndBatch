package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qspiders_Handeling_Windows {

	public static void main(String[] args) {
		
		String Login = "Login";
		String SignUp = "SignUp";
		String SignUpPage = "SignUpPage";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		String parentId = driver.getWindowHandle();
		WebElement multiplePopuP = driver.findElement(By.xpath("//button[@id='browserButton3']"));
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(multiplePopuP));
		act.scrollToElement(multiplePopuP);
		multiplePopuP.click();
		Set<String> allwindow = driver.getWindowHandles();
		for(String id:allwindow)
		{
			driver.switchTo().window(id);
			String url = driver.getCurrentUrl();
			if (url.contains(SignUp)) {
				System.out.println("Successfully Switched to "+SignUp);
				break;
			}
			
		}
	}
}
