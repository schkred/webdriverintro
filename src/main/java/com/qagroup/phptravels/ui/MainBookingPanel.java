package com.qagroup.phptravels.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import com.qagroup.phptravels.BasePhpTravels;

import io.qameta.allure.Step;

public class MainBookingPanel extends BasePhpTravels {

	private SearchContext root;

	@FindBy(css = "li[data-title='hotels']")
	private WebElement hotelsTab;

	@FindBy(css = "[name=checkin]")
	private WebElement checkInField;

	@FindBy(css = "[name=checkout]")
	private WebElement checkOutField;

	private static WebDriver driver;

	public MainBookingPanel(WebElement root) {
		super(driver);
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select 'Hotels' tab on Main booking panel")
	public void selectHotelsTab() {
		hotelsTab.click();
	}

	@Step("Open 'Check in' date picker")
	public DatePicker openHotelsCheckInDatePicker() {
		checkInField.click();
		return new DatePicker(datePicker);
	}

	@Step("Open 'Check out' date picker")
	public DatePicker openHotelsCheckOutDatePicker() {
		checkOutField.click();
		return datePicker();
	}
}
