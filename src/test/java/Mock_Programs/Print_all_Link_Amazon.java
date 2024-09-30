package Mock_Programs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_all_Link_Amazon {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a[contains(@href,'https')]"));
		for(int i=1;i<=allLinks.size();i++)
		{
			String link = driver.findElement(By.xpath("(//a[contains(@href,'https')])["+i+"]")).getAttribute("href");
			System.out.println(link);
		}

		driver.quit();
	}

}
