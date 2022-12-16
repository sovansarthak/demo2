package dummyframework1.pageComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import dummyframework1.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReporterNG xt= new ExtentReporterNG();
	ExtentReports extent=xt.getReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.pass(result.getThrowable());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String path = null;
		
		test.fail(result.getThrowable());
		try {
			path=takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}

