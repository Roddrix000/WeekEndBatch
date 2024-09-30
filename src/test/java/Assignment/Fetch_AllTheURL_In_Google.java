package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fetch_AllTheURL_In_Google {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver d= new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://www.google.com/");
		d.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("qspiders");
		d.findElement(By.xpath("//div[@aria-label='qspiders']")).click();
		Thread.sleep(2000);
		List<WebElement> links = d.findElements(By.xpath("//a[contains(@href,'qspiders')]"));
		for( WebElement ele:links)
		{
			System.out.println(ele.getAttribute("href"));
		}
		
		System.out.println("Done!!!!!");
		d.quit();
	}
}
