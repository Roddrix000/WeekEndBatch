package Mock_Programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_Auto_Suggestion_Google {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Ronald");
		List<WebElement> autosuggestion = driver.findElements(By.xpath("//span[contains(text(),'Ron') or contains(text(),'ron')]"));
		for(WebElement sugg:autosuggestion)
		{
			System.out.println(sugg.getText());
		}
		driver.quit();
	}
}
