package Annotations;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_on_Annotation {

	@Test
	public void chooseApplication() {
		Reporter.log("FlipKart Is being Selected", true);
	}

	@Test
	public void selectProduct() {
		Reporter.log("Iphone Has been Choosen.!!", true);
	}

	@Test
	public void placeOrder() {
		Reporter.log("Order has been placed Successfully..!!!", true);

	}

	@Test
	public void close() {
		Reporter.log("Application CLosed...!!!", true);

	}

	@BeforeTest
	public void StockCheckin() {
		Reporter.log("Check if its in Stock", true);
	}

	@AfterTest
	public void doneShopping() {
		Reporter.log("Happy Shooping...!!", true);

	}
}
