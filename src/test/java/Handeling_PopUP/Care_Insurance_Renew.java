package Handeling_PopUP;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Care_Insurance_Renew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.careinsurance.com/rhicl/proposalcp/renew/index-care");
		WebElement policyNumber = driver.findElement(By.id("policynumber"));
		policyNumber.click();
		policyNumber.sendKeys("ANX110033");
		driver.findElement(By.id("dob")).click();
		// Creating Object for Select class
		WebElement month = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectMonth = new Select(month);
		// Select Month
		month.click();
		Thread.sleep(1000);
		selectMonth.selectByVisibleText("Apr");

		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear = new Select(year);
		// Select Year
		year.click();
		Thread.sleep(1000);
		selectYear.selectByValue("1999");

		// Select Date
		List<WebElement> dates = driver.findElements(By.xpath("//tbody//tr//td//a"));
		for (WebElement e : dates) {
			if (e.getText().equals(5)) {
				e.click();
				break;
			}
		}

		driver.findElement(By.id("alternative_number")).sendKeys("8899554411");
		driver.findElement(By.id("renew_policy_submit")).click();

		if (driver.findElement(By.xpath("//span[text()='Please enter valid Policy No.']")).isDisplayed() == true) {
			System.out.println("Test Case Passed...!!!!");

		}

		driver.quit();

	}

}
