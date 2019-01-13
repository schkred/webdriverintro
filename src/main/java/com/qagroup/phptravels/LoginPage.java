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

	@Step("Login as username: <{username}> and password: <{password}>")
	public AccountPage LoginAs(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
		return new AccountPage(driver);
	}

	@Step("Enter username <{username}>")
	public void enterUserName(String username) {
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys(username);
	}

	@Step("Enter password <{password}>")
	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);
	}

	@Step("Click 'Login' button")
	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(By.cssSelector(".loginbtn"));
		loginButton.click();
	}
}
