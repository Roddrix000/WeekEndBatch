package Listeners_Implementation;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Working_with_Listners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName() + " Successfully Execution Started", true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName() + "Is Passed", true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName() + "Is Failed", true);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName() + "Is Skipped", true);
	}

}
