package Logics;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class LaunchEmulatorAndApp {

	public static Dimension dimensions;
	public static int screenCenter;
	public static int startPoint;
	public static int endPoint;
	public static PointerInput finger;

	public static void main(String[] args) throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "12");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.codifi.chola");
		caps.setCapability("appActivity", "com.codifi.chola.MainActivity");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");

		// Initialize the Appium Driver

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		// The app is now launched, and you can interact with it
		System.out.println("App launched successfully!");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//android.widget.EditText"));
		password.sendKeys("Bharath@1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Welcome Back,']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Proceed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Skip']")).click();
		Thread.sleep(5000);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Started " + timestamp);
		Set<String> scriptSize = GettingScreen("//android.view.View[contains(@content-desc,'%)')]", driver);
		System.out.println("Scripts size is " + scriptSize.size());
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		System.out.println("Ended " + timestamp1);
		driver.quit();

	}

	public static Set<String> GettingScreen(String xpath, AndroidDriver driver) {
		finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		dimensions = driver.manage().window().getSize();
		screenCenter = (int) (dimensions.getWidth() * 0.5);// Identify center point of screen for Y axis
		startPoint = (int) (dimensions.getHeight() * 0.8);// Identify beginning point of scroll for X axis
		endPoint = (int) (dimensions.getHeight() * 0.5);// Identify ending point of scroll

		Set<String> valuesList = new LinkedHashSet<>();
		List<String> currentList = new ArrayList<>();
		List<String> previousList = new ArrayList<>();
		boolean hasMoreElements = true;

		while (hasMoreElements) {

			// Locate elements to fetch
			List<WebElement> elements = driver.findElements(By.xpath(xpath));

			for (WebElement element : elements) {
				String value = element.getAttribute("content-desc");
				if (!valuesList.contains(value)) {
					currentList.add(value.split("\n")[0]);
				}
			}

			if (previousList.containsAll(currentList)) {
				hasMoreElements = false; // No new elements found, end the loop
			} else {
				previousList = new ArrayList<>(currentList);
				valuesList.addAll(currentList);
				// Swipe up the screen
				swipeTop(driver);
			}

		}
		return valuesList;
	}

	public static void swipeTop(AndroidDriver driver) {

		Sequence swipe = new Sequence(finger, 1);
		// Move finger into starting position
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), screenCenter,
				startPoint));

		// Finger goes up into contact with screen
		swipe.addAction(finger.createPointerDown(0));

		// Finger moves to End Position
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), screenCenter,
				endPoint));

		// Take out finger from screen
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));


	}
}
