package br.com.rsinet.hub_tdd.Testes;


import static org.testng.Assert.assertEquals;

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
import io.appium.java_client.android.AndroidDriver;

public class BuscaPelaLupa extends ConfigApp{

	private static AndroidDriver<MobileElement> driver;
	private static WebDriverWait wait;
	
	
	@Before
	public void Inicializa() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = ConfigApp.iniciaApp();
		
	}
	ExtentTest test = ExtentReportDemo.getTest();
	ExtentReports extent = ExtentReportDemo.getExtent();
	
	@Test
 	public void Executa() throws Exception {
		test = extent.startTest("Pesquisa pela lupa valida");
		Thread.sleep(3000);
        Home_Page.clk_Pesquisa(driver).click();
        String sProduto = ExcelUtils.getCellData(1, 0);
        Home_Page.clk_Pesquisa(driver).sendKeys(sProduto);
        Home_Page.clk_Lupa(driver).click();
        Scroll.scrollAndClick(driver, "HP PAVILION 15T TOUCH LAPTOP");
        Screenshot.TirarPrint(driver, "Busca Lupa Valido");
        assertEquals(true,  Products_Page.txt_Result(driver).getText().contains(ExcelUtils.getCellData(2, 1)));
        String screenShotPath = Screenshot.TirarPrint(driver, "Pesquisa pela lupa valida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));

	}
	@Test
 	public void ExecutaFalha() throws Exception {
		test = extent.startTest("Pesquisa pela lupa invalida");
		Thread.sleep(3000);
        Home_Page.clk_Pesquisa(driver).click();
        String sProdutoInvalido = ExcelUtils.getCellData(2, 0);
        Home_Page.clk_Pesquisa(driver).sendKeys(sProdutoInvalido);
		Thread.sleep(3000);
        Home_Page.clk_Lupa(driver).click();
        String sInvalido = Products_Page.txt_NoResult(driver).getText();
        
        assertEquals(false, sInvalido.contains("No Results for"));
        String screenShotPath = GetScreenshot.capture(driver, "Busca pela lupa invalida");
		test.log(LogStatus.PASS, "Funcionou: " + test.addScreenCapture(screenShotPath));

        
	}
	@After
	public void fechaDriver() {
		ConfigApp.closeDriver(driver);
	}
}