package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseOnlyParentWindow {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	driver.get("https://secure.indeed.com/");
	String parentwin = driver.getWindowHandle();
	driver.findElement(By.id("login-google-button")).click();
	Set<String> window = driver.getWindowHandles();
	for(String win:window)
	{
			if (win.equals(parentwin)) {
				driver.switchTo().window(win);
				driver.close();
			}
	}
	System.out.println("Successfully Parent Child Window");
}
}
