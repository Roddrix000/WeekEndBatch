package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_Auto_Suggestion {
public static void main(String[] args) {
	
	WebDriver d= new ChromeDriver();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	d.manage().window().maximize();
	d.get("https://www.flipkart.com/");
	d.findElement(By.name("q")).sendKeys("Iphone 15 Pro Max");
	List<WebElement> autoSuggestion = d.findElements(By.xpath("//div[contains(text(),'iphone')]"));
	for(WebElement ele:autoSuggestion)
	{
		System.out.println(ele.getText());
	}
	d.quit();
}
}
