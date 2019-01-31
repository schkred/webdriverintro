package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qagroup.phptravels.ui.TopNavigationBar;
import com.qagroup.tools.AbstractWebPage;

public class GenericPhpTravelsApp extends AbstractWebPage {

	@FindBy(css = "nav.navbar-default")
	private WebElement topNavigationBar;

	public GenericPhpTravelsApp(WebDriver driver) {
		super(driver);
	}

	public TopNavigationBar topNavigationBar() {
		return new TopNavigationBar(topNavigationBar);
	}

}
