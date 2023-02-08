package SwagLabsE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener 
{
	ExtentReports extent = ExtentReporterNG.getReportObject();
	//ExtentTest test= extent.createTest("testname");
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	public void onTestSuccess(ITestResult result) 
	{
		thread.get().log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		//test.fail(result.getThrowable());
		//test.log(Status.FAIL, "Test failed");
		WebDriver failedDriver=null;
		String FailedMathodName = result.getMethod().getMethodName();
		try {
			failedDriver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			thread.get().fail(result.getThrowable()).addScreenCaptureFromPath(FailureScreenshot(FailedMathodName, failedDriver), FailedMathodName);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	
	public void onStart(ITestContext context) 
	{
		String testname = context.getName();
		test = extent.createTest(testname);
		thread.set(test);
	}
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	

		
}

