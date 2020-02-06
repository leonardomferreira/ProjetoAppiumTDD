package br.com.rsinet.hub_tdd.utility;

import io.appium.java_client.android.AndroidDriver;

public class Scroll {

	 public static void scrollAndClick(AndroidDriver driver, String visibleText) {
	        driver.findElementByAndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
	                        + visibleText + "\").instance(0))")
	                .click();
}
}