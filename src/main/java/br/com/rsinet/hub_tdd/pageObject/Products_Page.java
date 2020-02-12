package br.com.rsinet.hub_tdd.pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Products_Page {

	private AndroidDriver driver;

	public static MobileElement txt_NoResult(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
	}

	public static MobileElement txt_Result(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView");
	}

	public static MobileElement txt_ResultLaptop(AndroidDriver driver) {
		return (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView");
	}

	public static MobileElement txt_Filters(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewFilter");
	}

	public static MobileElement txt_FilterDisplay(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewFilter");

	}

	public static MobileElement titulo_Produto(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewProductName");

	}

	public static MobileElement txt_NoProducts(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");

	}
	public static MobileElement btn_Apply(AndroidDriver driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewApply");
		
	}

}