package br.com.rsinet.hub_tdd.Testes;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.utility.ConfigApp;
import br.com.rsinet.hub_tdd.utility.ExtentReportDemo;
import br.com.rsinet.hub_tdd.utility.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BuscaPelaTelaInicial extends ConfigApp {
	
	private static AndroidDriver<MobileElement> driver;
	private static ExtentReports extent;
	private ExtentTest test;
	
	@Before
	public static void Inicializa() throws MalformedURLException {

		driver = ConfigApp.iniciaApp();
		ExtentTest test = ExtentReportDemo.getTest();
		extent = ExtentReportDemo.getExtent();
	}

	@Test
	public void Executa() {

        ExtentTest test = extent.createTest("Test One", "Sample Test Case");
        test.log(Status.INFO, "Test One started");

		Scroll.scrollAndClick(driver, "LAPTOPS");
        test.log(Status.PASS, "Click Category");

		Scroll.scrollAndClick(driver, "HP CHROMEBOOK 14 G1(ES)");
        test.log(Status.PASS, "Click Laptop");

        assertEquals(true , Products_Page.txt_ResultLaptop(driver).getText().contains("HP CHROMEBOOK 14 G1(ES)"));
	}
	
}
