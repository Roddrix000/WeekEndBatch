package Working_on_TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CustomerModule {

	
	@Test(priority = 0)
	
	public void createCustomer()
	{
		Assert.fail();
		Reporter.log("Created Customer", true);
	}
	
	@Test(priority = 2,dependsOnMethods = {"createCustomer","modifyCustomer"})
	public void deleteCustomer()
	{
		Reporter.log("Deleted Customer", true);
	}
	@Test(priority = 1,dependsOnMethods = "deleteCustomer")
	public void modifyCustomer()
	{
		Reporter.log("Modified Customer", true);
	}
	
}
