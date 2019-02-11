package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.TopNavigationBar;
import com.qagroup.tools.AbstractWebPage;

public class BasePhpTravelsApp extends AbstractWebPage {

	@FindBy(css = "nav.navbar-default")
	private WebElement topNavigationBar;

	@FindBy(css = ".datepicker[style*='display: block']")
	private WebElement datePicker;

	public BasePhpTravelsApp(WebDriver driver) {
		super(driver);
	}

	public TopNavigationBar topNavigationBar() {
		return new TopNavigationBar(topNavigationBar);
	}

	public DatePicker datePicker() {
		return new DatePicker(datePicker);
	}

}
