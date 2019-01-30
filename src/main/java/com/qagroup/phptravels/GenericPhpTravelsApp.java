package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qagroup.phptravels.ui.TopNavigationBar;

public class GenericPhpTravelsApp {

	@FindBy(css = "nav.navbar-default")
	private WebElement topNavigationBar;

	private WebDriver driver;

	public GenericPhpTravelsApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public TopNavigationBar topNavigationBar() {
		return new TopNavigationBar(topNavigationBar);
	}

}
