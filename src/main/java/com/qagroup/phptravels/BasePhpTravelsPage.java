package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.TopNavigationBar;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class BasePhpTravelsPage {

	private WebDriver driver;
	
	@FindBy(css = "nav.navbar-default")
	private WebElement topNavigationBar;
	
	@FindBy(css = ".datepicker[style*='display: block']")
	private WebElement datePicker;

	public BasePhpTravelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public TopNavigationBar topNavigationBar() {
		return new TopNavigationBar(topNavigationBar);
	}

	@Step("Read current URL")
	@Attachment("URL")
	public String readCurrentURL(WebDriver driver) {
		return this.driver.getCurrentUrl();
	}
	
	public DatePicker getDatePicker() {
		return new DatePicker(datePicker);
	}

}
