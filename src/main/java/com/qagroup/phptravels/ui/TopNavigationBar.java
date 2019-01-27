package com.qagroup.phptravels.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import com.qagroup.phptravels.LoginPage;
import com.qagroup.phptravels.MainPage;

import io.qameta.allure.Step;

public class TopNavigationBar {

	@FindBy(xpath = ".//li [a/text()='Home']")
	private WebElement homeTab;

	@FindBy(css = ".navbar #li_myaccount")
	private WebElement myAccountButton;

	@FindBy(css = ".navbar #li_myaccount .dropdown-menu")
	private WebElement myAccountDropdown;

	private SearchContext root;

	private WebDriver driver;

	public TopNavigationBar(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select 'Home' tab")
	public MainPage selectHome() {
		homeTab.click();
		return new MainPage(driver);
	}

	@Step("Navigate to Login page")
	public LoginPage navigateToLoginPage() {
		myAccountButton.click();
		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(text(), 'Login')]"));
		loginOption.click();
		return new LoginPage(driver);
	}

}
