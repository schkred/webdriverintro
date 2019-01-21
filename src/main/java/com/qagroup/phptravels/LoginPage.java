package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement usernameField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(css = ".loginbtn")
	private WebElement loginButton;
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
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
		usernameField.sendKeys(username);
	}

	@Step("Enter password <{password}>")
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	@Step("Click 'Login' button")
	public void clickLoginButton() {
		loginButton.click();
	}
}
