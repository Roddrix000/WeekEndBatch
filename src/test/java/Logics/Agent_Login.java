package Logics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Agent_Login {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--allow-file-access-from-files", "--use-fake-ui-for-media-stream", "--allow-file-access");
		options.addArguments("--use-fake-device-for-media-stream");
		// options.addArguments("--use-file-for-fake-video-capture="+video);
		options.setCapability("goog:loggingPrefs", logPrefs);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.get("https://vkycuat.unitybank.co.in:5560");
		Thread.sleep(10000);
		driver.findElement(By.id("formBasicDomain")).click();
		driver.findElement(By.id("formBasicDomain")).sendKeys("unity_uat");
		Thread.sleep(1000);
		driver.findElement(By.id("formBasicEmail")).click();
		driver.findElement(By.id("formBasicEmail")).sendKeys("unity_uat_agent_3");
		Thread.sleep(1000);
		driver.findElement(By.id("formBasicPassword")).click();
		driver.findElement(By.id("formBasicPassword")).sendKeys("unity_uat_agent_3");
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//DIV[normalize-space(.)='Submit']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("test-done-btn")).click();

//		System.out.println("Launching second Browser as Auditor");
//		DesiredCapabilities cap1 = new DesiredCapabilities();
//		cap1.setBrowserName("chrome");
//		cap1.setCapability(ChromeOptions.CAPABILITY, options);
//		WebDriver driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap1);
//		driver2.manage().window().maximize();
//		driver2.get("https://vkycuat.unitybank.co.in:5560");
//		Thread.sleep(3000);
//		driver2.findElement(By.id("formBasicDomain")).click();
//		driver.findElement(By.id("formBasicDomain")).sendKeys("unity_uat");
//		Thread.sleep(1000);
//		driver2.findElement(By.id("formBasicEmail")).click();
//		driver2.findElement(By.id("formBasicEmail")).sendKeys("unity_uat_agent_3");
//		Thread.sleep(1000);
//		driver2.findElement(By.id("formBasicPassword")).click();
//		driver2.findElement(By.id("formBasicPassword")).sendKeys("unity_uat_agent_3");
//		driver2.findElement(By.xpath("//div[text()='Concurrent-Auditor']")).click();
//		Thread.sleep(10000);
//		driver2.findElement(By.xpath("//DIV[normalize-space(.)='Submit']")).click();
		
		// Switch to the newly opened screen sharing window
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}

		// Now, you need to simulate keyboard actions to select the tab and click "Share" using Robot class
		

		Robot robot = new Robot();

		// Simulate key presses to move down in the list of tabs
		robot.keyPress(KeyEvent.VK_TAB);
		
		//press Right Arrow
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		// Repeat to move through the list of options if necessary
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);

		// Finally, simulate pressing Enter to select and share
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// If there's any delay, add appropriate sleep to give time for dialog actions to reflect
		Thread.sleep(2000);

	}
}
