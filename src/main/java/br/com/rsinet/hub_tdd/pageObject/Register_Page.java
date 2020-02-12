package br.com.rsinet.hub_tdd.pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Register_Page {
	

	private static AndroidDriver driver;

	public static MobileElement txtbx_userName(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]");
		
	}
	public static MobileElement txtbx_Email(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]");
	
	}
	public static MobileElement txtbx_Password(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]");
	
 }
	public static MobileElement txtbx_ConfirmPassword(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]");
	
 }
	public static MobileElement txtbx_FirstName(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]");
	
}
	public static MobileElement txtbx_LastName(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]");
	}
	public static MobileElement txtbx_PhoneNumber(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]");
	}
	public static MobileElement txtbx_State(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]");

	}
	public static MobileElement txtbx_Address(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]");

	}
	public static MobileElement txtbx_City(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]");

	}
	public static MobileElement txtbx_Zip(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]");

}
	public static MobileElement txtbx_Country(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/linearLayoutCountry");

	}
	public static MobileElement btn_Registrar(AndroidDriver driver) {
        return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/buttonRegister");
	}
}