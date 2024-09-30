package Mock_Programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multiSelect_ListBox {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Automation Initiated");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.com/");
		WebElement multiSelect = driver.findElement(By.id("multiselect1"));
		//Select the options
		Select sle= new Select(multiSelect);
		sle.selectByVisibleText("Swift");
		Thread.sleep(1000);
		sle.selectByVisibleText("Hyundai");
		Thread.sleep(1000);
		sle.deselectByVisibleText("Hyundai");
		List<WebElement> opts = driver.findElements(By.xpath("//h2[text()='Multi Selection box']/..//div//option"));
		ArrayList<String> optionsName= new ArrayList<String>();
		for(WebElement op:opts)
		{
			optionsName.add(op.getText());
			
		}
		Collections.sort(optionsName);
		System.out.println(optionsName);
		Thread.sleep(1000);
		driver.quit();
		System.out.println("Automation Done");
	}
}
