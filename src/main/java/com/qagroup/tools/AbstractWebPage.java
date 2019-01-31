package com.qagroup.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AbstractWebPage {
	
	private WebDriver driver;

	public AbstractWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@Step("Read current URL")
	@Attachment("URL")
	public String readCurrentURL (WebDriver driver) {
		return this.driver.getCurrentUrl();
	}
}
