package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Assign4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 15 pro max" +Keys.ENTER);
		String parentWind = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone') and contains(@class,'a-size-medium')]")).click();
		Thread.sleep(2000);
		Set<String> allWin = driver.getWindowHandles();
		for(String win:allWin)
		{
			if (!win.equals(parentWind)) {
				driver.switchTo().window(win);
				System.out.println("Successfully Switched");
			}
		}
		Thread.sleep(3000);
		WebElement addtoCart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		//Scroll till Element 
		Actions act= new Actions(driver);
		act.scrollToElement(addtoCart);
		Thread.sleep(1000);
		addtoCart.click();
		driver.quit();
	}
}
