package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AccountPage {

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Read current URL")
	@Attachment("URL")
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	@Step("Read username from Header")
	@Attachment("Username")
	public String readUsername () {
		WebElement userNameOnHeader = driver.findElement(By.cssSelector(".navbar .user_menu>li:nth-of-type(1)>a"));
		return userNameOnHeader.getText();
	}
}
