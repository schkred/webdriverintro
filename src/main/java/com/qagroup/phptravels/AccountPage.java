package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String readUsername () {
		WebElement userNameOnHeader = driver.findElement(By.cssSelector(".navbar .user_menu>li:nth-of-type(1)>a"));
		return userNameOnHeader.getText();
	}
}
