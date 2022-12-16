package dummyframework1.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	
	public ExtentReports getReport() {
		
		String path=System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Run");
		reporter.config().setDocumentTitle("Automation Test Runs");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

}