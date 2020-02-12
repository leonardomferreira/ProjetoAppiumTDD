package br.com.rsinet.hub_tdd.utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportDemo {

	static ExtentReports extent;
	static ExtentTest test;

	public static void iniciaReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentScreenshot.html");

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
