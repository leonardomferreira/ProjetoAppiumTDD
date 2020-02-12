package br.com.rsinet.hub_tdd.Testes;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.utility.ConfigApp;
import br.com.rsinet.hub_tdd.utility.Constant;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.ExtentReportDemo;
import br.com.rsinet.hub_tdd.utility.GetScreenshot;
import br.com.rsinet.hub_tdd.utility.Screenshot;
import br.com.rsinet.hub_tdd.utility.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class BuscaPelaLupa extends ConfigApp{

	private AndroidDriver driver;
	private TouchAction action;

	
	@Before
	public void Inicializa() throws Exception{
		driver = ConfigApp.iniciaApp();
		
	}
	ExtentTest test = ExtentReportDemo.getTest();
	ExtentReports extent = ExtentReportDemo.getExtent();
	
	@Test
 	public void deveBuscarPorProdutoPorTextoValido() throws Exception {
		action = new TouchAction(driver);

		test = extent.startTest("Pesquisa pela lupa valida");
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();
        Home_Page.clk_Pesquisa(driver).click();
        Home_Page.clk_Pesquisa(driver).sendKeys("hp");
        Home_Page.clk_Lupa(driver).click();
        Scroll.scrollAndClick(driver, "HP PAVILION 15T TOUCH LAPTOP");
        Screenshot.TirarPrint(driver, "Busca Lupa Valido");
        assertEquals(true,  Products_Page.txt_Result(driver).getText().contains("HP"));
        String screenShotPath = Screenshot.TirarPrint(driver, "Pesquisa pela lupa valida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));

	}
	@Test
 	public void deveBuscarPorProdutoPorTextoInvalido() throws Exception {
		test = extent.startTest("Pesquisa pela lupa invalida");
		action = new TouchAction(driver);

		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))).perform();
        Home_Page.clk_Pesquisa(driver).click();
        Home_Page.clk_Pesquisa(driver).sendKeys("samsung");
        Home_Page.clk_Lupa(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();
        String sInvalido = Products_Page.txt_NoProducts(driver).getText();
        
        assertEquals(true, sInvalido.contains("No results for"));
        String screenShotPath = GetScreenshot.capture(driver, "Busca pela lupa invalida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));

        
	}
	@After
	public void fechaDriver() {
		ConfigApp.closeDriver(driver);
	}
}