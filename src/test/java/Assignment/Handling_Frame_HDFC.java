package Assignment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handling_Frame_HDFC {
	
	public static Set<String> allWin;
	public static String welcomeHDFC;
	public static void main(String[] args) {
		
		
		//Handeling the BrowserPop UP
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com");
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent title "+driver.getTitle());
		WebElement logInBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		waitUntilElement(driver,logInBtn);
		//Moving mouse on loginButton
		Actions act = new Actions(driver);
		act.moveToElement(logInBtn).perform();
		driver.findElement(By.linkText("NetBanking")).click();
		allWin = driver.getWindowHandles();
		//Switching to another window
		for( String win:allWin)
		{
			if (!win.equals(parentWin)) {
				driver.switchTo().window(win);
				System.out.println("Successfully Switched..!!!!"+ driver.getTitle());
				welcomeHDFC=win;
				break;
			}
		}
		WebElement frameid = driver.findElement(By.xpath("//frame[@name='login_page']"));
		driver.switchTo().frame(frameid);
		WebElement knowMore = driver.findElement(By.xpath("(//span[contains(text(),'Your security is')])[last()]/..//a"));
		waitUntilElement(driver,knowMore);
		knowMore.click();
		allWin = driver.getWindowHandles();
		String bestSafty;
		for( String win:allWin)
		{
			if (!win.equals(parentWin)& !win.equals(welcomeHDFC)) {
				driver.switchTo().window(win);
				bestSafty=win;
				System.out.println("Successfully Switched..!!!!"+ driver.getTitle());
				break;
			}
		}
		
		List<WebElement> allLanguage = driver.findElements(By.xpath("//a[contains(@title,'/Common/Campaign/')]"));
		for(WebElement lang:allLanguage)
		{
			
			System.out.println(lang.getText());
		}
		
		
		driver.quit();
	}
	
	
	public static void waitUntilElement(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void switchingWindows()
	{
		
	}
}
