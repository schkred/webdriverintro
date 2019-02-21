package com.qagroup.phptravels.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class MainBookingPanel {

	private SearchContext root;

	@FindBy(css = "[data-title='hotels']")
	private WebElement hotelsTab;

	@FindBy(css = "[name=checkin]")
	private WebElement checkInField;

	@FindBy(css = "[name=checkout]")
	private WebElement checkOutField;

	public MainBookingPanel(WebElement mainBookingPanel) {
		this.root = mainBookingPanel;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select 'Hotels' tab on Main booking panel")
	public void selectHotelsTab() {
		hotelsTab.click();
	}

	@Step("Open 'Check in' date picker")
	public void openHotelsCheckIn() {
		checkInField.click();
	}

	@Step("Open 'Check out' date picker")
	public void openHotelsCheckOut() {
		checkOutField.click();
	}
}
