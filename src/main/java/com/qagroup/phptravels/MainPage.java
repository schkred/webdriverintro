package com.qagroup.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.MainBookingPanel;

import io.qameta.allure.Step;

public class MainPage extends GenericPhpTravelsApp {

	private WebDriver driver;

	@FindBy(css = ".navbar #li_myaccount")
	private WebElement myAccountButton;
	
	@FindBy(css = ".navbar li#li_myaccount .dropdown-menu")
	private WebElement myAccountDropdown;
	
	// Main panel on the Home page where user can book Hotel, Flight, etc.
	@FindBy(css = ".cell .col-md-12:not(.col-xs-6)")
	private WebElement mainBookingPanel;
	
	@FindBy(css = "[name=checkin]")
	private WebElement checkInField;
	
	@FindBy(css = "[name=checkout]")
	private WebElement checkOutField;
	
	@FindBy(css = ".datepicker[style*='display: block']")
	private WebElement datePicker;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public MainBookingPanel mainBookingPanel() {
		return new MainBookingPanel(mainBookingPanel);
	}
	
	public DatePicker datePicker() {
		return new DatePicker(datePicker);
	}
	
	@Step("Open 'Check in' date picker")
	public DatePicker openHotelsCheckInDatePicker() {
		checkInField.click();
		return datePicker();
	}
	
	@Step("Open 'Check out' date picker")
	public DatePicker openHotelsCheckOutDatePicker() {
		checkOutField.click();
		return datePicker();
	}
	
	@Step("Navigate to Login page")
	public LoginPage navigateToLoginPage() {
		myAccountButton.click();

		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(.,'Login')]"));
		loginOption.click();
		return new LoginPage(driver);
	}
}
