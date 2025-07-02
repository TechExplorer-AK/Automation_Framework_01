package genericutility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test=ereport.createTest(result.getName());
		test.log(Status.INFO, "test execution started");
		Reporter.log("test execution started",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Script is failed");
		Reporter.log("Test Script is failed",true);

		TakesScreenshot ts=(TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		try {
			wUtil.getPhoto(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
