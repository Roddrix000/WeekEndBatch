package Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowser {
	public static String parentTitle1="Sign In | Indeed Accounts";
	public static String childTitle1="Sign in - Google Accounts";
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();
	driver.get("https://secure.indeed.com/");
	String ParentTitle = driver.getTitle();
	String parentwin = driver.getWindowHandle();
	driver.findElement(By.id("login-google-button")).click();
	Set<String> window = driver.getWindowHandles();
	String childTitle=null;
	for(String win:window)
	{
			if (!win.equals(parentwin)) {
				driver.switchTo().window(win);
				Thread.sleep(2000);
				childTitle = driver.getTitle();
			}
	}
	System.out.println("Parent Title " + ParentTitle);
	System.out.println("Child Title " + childTitle);
}
}
