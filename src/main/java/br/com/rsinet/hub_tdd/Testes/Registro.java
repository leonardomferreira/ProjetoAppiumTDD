package br.com.rsinet.hub_tdd.Testes;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.numeric.NumericPhone;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.utility.ConfigApp;
import br.com.rsinet.hub_tdd.utility.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Registro extends ConfigApp{

	private static AndroidDriver<MobileElement> driver;
	TouchAction action;
	

	@BeforeTest
	public static void Inicializa() throws MalformedURLException {

		driver = ConfigApp.iniciaApp();

	}

	@Test
	public void Executa() {
		
		action = new TouchAction(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.lnk_Home(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.lnk_Menu(driver)));
		Home_Page.lnk_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.lnk_Login2(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.clk_CreateAccount(driver)));

		Home_Page.clk_CreateAccount(driver).click();

		Register_Page.txtbx_userName(driver).click();
		Register_Page.txtbx_userName(driver).sendKeys("le646");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_Email(driver).click();
		Register_Page.txtbx_Email(driver).sendKeys("leoanrdoe@gmail.com");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_Password(driver).click();
		Register_Page.txtbx_Password(driver).sendKeys("Test@123");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_ConfirmPassword(driver).click();
		Register_Page.txtbx_ConfirmPassword(driver).sendKeys("Test@123");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_FirstName(driver).click();
		Register_Page.txtbx_FirstName(driver).sendKeys("Antonio");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		Register_Page.txtbx_LastName(driver).click();
		Register_Page.txtbx_LastName(driver).sendKeys("Ferreira");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_PhoneNumber(driver).click();
		NumericPhone.Numeric(driver);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_State(driver).click();
		Register_Page.txtbx_State(driver).sendKeys("Sao sao");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_Address(driver).click();
		Register_Page.txtbx_Address(driver).sendKeys("Rua gglga");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_City(driver).click();
		Register_Page.txtbx_City(driver).sendKeys("Osasco");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Register_Page.txtbx_Zip(driver).sendKeys("04923-392");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Scroll.scrollAndClick(driver, "Brazil");
		Scroll.scrollAndClick(driver, "REGISTER");
		action.tap(PointOption.point(420, 1778)).perform();
	}

}