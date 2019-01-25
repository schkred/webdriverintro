package com.qagroup.phptravels;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class NavigationBar {

	@FindBy(xpath=".//li [a/text()='Home']")
	private WebElement homeTab;

	private SearchContext root;

	public NavigationBar(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step ("Select 'Home' tab")
	public void selectHome() {
		homeTab.click();
	}

}
