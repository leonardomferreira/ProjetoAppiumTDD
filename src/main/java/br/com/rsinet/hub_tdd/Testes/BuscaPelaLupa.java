package br.com.rsinet.hub_tdd.Testes;


import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Products_Page;
import br.com.rsinet.hub_tdd.utility.ConfigApp;
import br.com.rsinet.hub_tdd.utility.Constant;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.ExtentReportDemo;
import br.com.rsinet.hub_tdd.utility.Screenshot;
import br.com.rsinet.hub_tdd.utility.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BuscaPelaLupa extends ConfigApp{

	private static AndroidDriver<MobileElement> driver;
	private static WebDriverWait wait;
	private static ExtentReports extent;
	private ExtentTest test;
	
	@Before
	public static void Inicializa() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = ConfigApp.iniciaApp();
		ExtentTest test = ExtentReportDemo.getTest();
		extent = ExtentReportDemo.getExtent();
	}
	@Test
 	public void Executa() throws Exception {
        ExtentTest test = extent.createTest("Test Lupa Valido", "Sample Test Case");
		Thread.sleep(3000);
        Home_Page.clk_Pesquisa(driver).click();
        String sProduto = ExcelUtils.getCellData(1, 0);
        Home_Page.clk_Pesquisa(driver).sendKeys(sProduto);
        Home_Page.clk_Lupa(driver).click();
        Scroll.scrollAndClick(driver, "HP PAVILION 15T TOUCH LAPTOP");
        Screenshot.TirarPrint(driver, "Busca Lupa Valido");
        assertEquals(true,  Products_Page.txt_Result(driver).getText().contains(ExcelUtils.getCellData(2, 1)));
//        test.log(LogStatus.PASS, "Test passed");
	}
	@Test
 	public void ExecutaFalha() throws Exception {
        ExtentTest test = extent.createTest("Test Lupa Invalido", "Sample Test Case");
		Thread.sleep(3000);
        Home_Page.clk_Pesquisa(driver).click();
        String sProdutoInvalido = ExcelUtils.getCellData(2, 0);
        Home_Page.clk_Pesquisa(driver).sendKeys(sProdutoInvalido);
		Thread.sleep(3000);
        Home_Page.clk_Lupa(driver).click();
        String sInvalido = Products_Page.txt_NoResult(driver).getText();
        
        assertEquals(false, sInvalido.contains("No Results for"));
        
	}
}