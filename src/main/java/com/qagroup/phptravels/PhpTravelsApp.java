package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;

import com.qagroup.tools.Browser;

public class PhpTravelsApp {

	private WebDriver driver;

	public LoginPage openLoginPage() {
		driver = Browser.open();
		driver.get("https://www.phptravels.net/login");
		return new LoginPage(driver);
	}

	public void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
