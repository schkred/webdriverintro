package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenericPhpTravelsApp {
	
	@FindBy(css=".navbar-default")
	private WebElement NavigationBar;
	
	private WebDriver driver;

	public GenericPhpTravelsApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}
