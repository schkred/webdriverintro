package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class MainPage {

	private WebDriver driver;

	@FindBy(css = ".navbar #li_myaccount")
	private WebElement myAccountButton;

	@FindBy(css = ".navbar #li_myaccount .dropdown-menu")
	private WebElement myAccountDropdown;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Navigate to Login page")
	public LoginPage navigateToLoginPage() {
		myAccountButton.click();

		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(text(), 'Login')]"));
		loginOption.click();
		return new LoginPage(driver);
	}
}
