package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GenericPhpTravelsApp {
	
	private WebDriver driver;

	public GenericPhpTravelsApp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}
