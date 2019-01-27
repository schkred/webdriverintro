package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qagroup.phptravels.ui.MainBookingPanel;

public class MainPage extends GenericPhpTravelsApp {

	private WebDriver driver;

	// Main panel on the Home page where user can book Hotel, Flight, etc.
	@FindBy(css = ".cell .col-md-12:not(.col-xs-6)")
	private WebElement mainBookingPanel;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public MainBookingPanel mainBookingPanel() {
		return new MainBookingPanel(mainBookingPanel);
	}
}
