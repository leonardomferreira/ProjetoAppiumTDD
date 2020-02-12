package br.com.rsinet.hub_tdd.Testes;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.utility.ConfigApp;
import br.com.rsinet.hub_tdd.utility.ExtentReportDemo;
import br.com.rsinet.hub_tdd.utility.GetScreenshot;
import br.com.rsinet.hub_tdd.utility.Screenshot;
import br.com.rsinet.hub_tdd.utility.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class BuscaPelaTelaInicial extends ConfigApp {

	private AndroidDriver<MobileElement> driver;
	private TouchAction action;

	ExtentTest test = ExtentReportDemo.getTest();
	ExtentReports extent = ExtentReportDemo.getExtent();
	
	@Before
	public void Inicializa() throws MalformedURLException {

		driver = ConfigApp.iniciaApp();

	}


	@Test
	public void deveBuscarUmProdutoPelaHomeValido() throws IOException {
	
		test = extent.startTest("Pesquisa pela tela inicial valida");
		action = new TouchAction(driver);

		Scroll.scrollAndClick(driver, "LAPTOPS");

		Scroll.scrollAndClick(driver, "HP CHROMEBOOK 14 G1(ES)");
		assertTrue(Products_Page.titulo_Produto(driver).getText().contains("HP CHROMEBOOK 14 G1(ES)"));

		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenshot.capture(driver, "Busca pela tela inicial valida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}
	@Test
	public void deveBuscarUmProdutoPelaHomeInvalido() throws IOException, InterruptedException {
		test = extent.startTest("Pesquisa pela tela inicial invalida");
		action = new TouchAction(driver);

		Scroll.scrollAndClick(driver, "HEADPHONES");
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))).perform();
		Products_Page.txt_Filters(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))).perform();
		Scroll.scrollAndClick(driver, "BY COMPATIBILITY");
		Scroll.scrollAndClick(driver, "Smart phone");
		Scroll.scrollAndClick(driver, "BY COMPATIBILITY");
		Scroll.scrollAndClick(driver, "BY CONNECTOR");
		Scroll.scrollAndClick(driver, "BlueTooth");
		Scroll.scrollAndClick(driver, "BY CONNECTOR");
		Products_Page.btn_Apply(driver).click();

		assertTrue(Products_Page.txt_NoProducts(driver).getText().contains("No results"));
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenshot.capture(driver, "Busca pela tela inicial invalida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}
	@After
	public void fechaDriver() {
		ConfigApp.closeDriver(driver);
	}

}
