package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Login as username: {0} and password: {1}")
	public AccountPage LoginAs(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
		return new AccountPage(driver);
	}

	public void enterUserName(String username) {
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(By.cssSelector(".loginbtn"));
		loginButton.click();
	}
}
