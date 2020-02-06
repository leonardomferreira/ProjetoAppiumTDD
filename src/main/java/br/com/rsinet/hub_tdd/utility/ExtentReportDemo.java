package br.com.rsinet.hub_tdd.utility;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	static ExtentTest test;
	
	public static void iniciaReport() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html");
	    
	}
	
	public static void fechaReport() {
		extent.flush();
	}
	public static ExtentTest getTest() {
		return test;
	}
	public static ExtentReports getExtent() {
		return extent;
		
	}
}
