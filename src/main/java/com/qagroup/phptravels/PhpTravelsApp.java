package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;

import com.qagroup.tools.Browser;

import io.qameta.allure.Step;

public class PhpTravelsApp {
	private static final String LOGIN_PAGE_URL = "https://www.phptravels.net/login";

	private WebDriver driver;

	@Step("Open Login page by URL: " + LOGIN_PAGE_URL)
	public LoginPage openLoginPage() {
		driver = Browser.open();
		driver.get(LOGIN_PAGE_URL);
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
