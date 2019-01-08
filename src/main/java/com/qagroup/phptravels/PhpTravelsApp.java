package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;

import com.qagroup.tools.Browser;

import io.qameta.allure.Step;

public class PhpTravelsApp {

	private WebDriver driver;

	@Step("Open Login page")
	public LoginPage openLoginPage() {
		driver = Browser.open();
		driver.get("https://www.phptravels.net/login");
		return new LoginPage(driver);
	}

	@Step("Close the application")
	public void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
