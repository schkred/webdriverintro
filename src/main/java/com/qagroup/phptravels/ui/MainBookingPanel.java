package com.qagroup.phptravels.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class MainBookingPanel {

	//	@FindBy(css = ".cell .col-md-12:not(.col-xs-6)")
	private SearchContext root;

	@FindBy(css = ".datepicker[style*='display: block']")
	private WebElement datePicker;

	@FindBy(css = "[data-title='hotels']")
	private WebElement hotelsTab;

	@FindBy(css = "[name=checkin]")
	private WebElement checkInField;

	@FindBy(css = "[name=checkout]")
	private WebElement checkOutField;

	public MainBookingPanel(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	public DatePicker getDatePicker() {
		return new DatePicker(datePicker);
	}

	@Step("Select 'Hotels' tab on Main booking panel")
	public void selectHotelsTab() {
		hotelsTab.click();
	}

	@Step("Open 'Check in' date picker")
	public DatePicker openHotelsCheckInDatePicker() {
		checkInField.click();
		return getDatePicker();
	}

	@Step("Open 'Check out' date picker")
	public DatePicker openHotelsCheckOutDatePicker() {
		checkOutField.click();
		return getDatePicker();
	}
}
