package com.qagroup.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AccountPage extends BasePhpTravelsPage{

	private WebDriver driver;
	
	@FindBy(css = ".navbar .user_menu>li:nth-of-type(1)>a")
	private WebElement userNameOnHeader;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Read username from Header")
	@Attachment("Username")
	public String readUsername () {
		return userNameOnHeader.getText();
	}
}
