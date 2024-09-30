package Mock_Programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handeling_Notification_Alert_PopUp {

	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://pib.gov.in/indexd.aspx");
	}
}
