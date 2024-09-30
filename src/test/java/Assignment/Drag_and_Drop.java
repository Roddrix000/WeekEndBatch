package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drag_and_Drop {

	public static void main(String[] args) {

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.get("https://demoapps.qspiders.com/");
		d.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		WebElement WebElementText = d.findElement(By.xpath("//section[text()='Web Elements']"));
		waitUntil(d, WebElementText, "Visible");
		WebElementText.click();
		d.findElement(By.xpath("//Section[text()='Mouse Actions']")).click();
		d.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
		WebElement dragPosition = d.findElement(By.linkText("Drag Position"));
		waitUntil(d, dragPosition, "Visible");
		dragPosition.click();
		WebElement mobileCharger = d.findElement(By.xpath("//div[text()='Mobile Charger']"));
		waitUntil(d, mobileCharger, "Clickable");
		// Actions class
		Actions act = new Actions(d);
		WebElement Mobile = d.findElement(By.xpath("//div[text()='Mobile Accessories']/.."));
		act.dragAndDrop(mobileCharger, Mobile).build().perform();
		System.out.println("Done...!!!");
		d.quit();
	}

	public static void waitUntil(WebDriver d, WebElement ele, String uiAction) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
		if (uiAction.equals("Visible")) {

			wait.until(ExpectedConditions.visibilityOf(ele));
		} else if (uiAction.equals("Clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
	}
}
