package br.com.rsinet.hub_tdd.Testes;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

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
import io.appium.java_client.android.AndroidDriver;

public class BuscaPelaTelaInicial extends ConfigApp {

	private static AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReportDemo.getTest();
	ExtentReports extent = ExtentReportDemo.getExtent();
	
	@Before
	public void Inicializa() throws MalformedURLException {

		driver = ConfigApp.iniciaApp();

	}


	@Test
	public void Executa() throws IOException {
		test = extent.startTest("Pesquisa pela tela inicial valida");

		Scroll.scrollAndClick(driver, "LAPTOPS");

		Scroll.scrollAndClick(driver, "HP CHROMEBOOK 14 G1(ES)");

		assertEquals(true, Products_Page.txt_ResultLaptop(driver).getText().contains("HP CHROMEBOOK 14 G1(ES)"));
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenshot.capture(driver, "Busca pela tela inicial valida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));
	}
	@After
	public void fechaDriver() {
		ConfigApp.closeDriver(driver);
	}

}
