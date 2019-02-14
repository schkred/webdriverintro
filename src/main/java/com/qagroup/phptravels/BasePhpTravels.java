package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.TopNavigationBar;
import com.qagroup.tools.AbstractWebPage;

public class BasePhpTravels extends AbstractWebPage {

	@FindBy(css = "nav.navbar-default")
	private WebElement topNavigationBar;

	@FindBy(css = ".datepicker[style*='display: block']")
	protected WebElement datePicker;

	private WebDriver driver;

	public BasePhpTravels(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public TopNavigationBar topNavigationBar() {
		return new TopNavigationBar(topNavigationBar);
	}

	public DatePicker datePicker() {
		return new DatePicker(datePicker);
	}

}
