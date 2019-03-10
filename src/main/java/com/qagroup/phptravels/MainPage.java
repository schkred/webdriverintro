package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qagroup.phptravels.ui.MainBookingPanel;

import io.qameta.allure.Step;

public class MainPage extends BasePhpTravelsPage {

	protected WebDriver driver;

	@FindBy(css = ".navbar #li_myaccount")
	private WebElement myAccountButton;

	@FindBy(css = ".navbar li#li_myaccount .dropdown-menu")
	private WebElement myAccountDropdown;

	// Main panel on the Home page where user can book Hotel, Flight, etc.
	@FindBy(css = ".cell .col-md-12:not(.col-xs-6)")
	private WebElement mainBookingPanel;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public MainBookingPanel getMainBookingPanel() {
		return new MainBookingPanel(mainBookingPanel);
	}

	@Step("Navigate to Login page")
	public LoginPage navigateToLoginPage() {
		myAccountButton.click();
		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(.,'Login')]"));
		loginOption.click();
		return new LoginPage(driver);
	}
}
