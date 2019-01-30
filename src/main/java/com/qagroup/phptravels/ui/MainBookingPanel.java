package com.qagroup.phptravels.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class MainBookingPanel {

	@FindBy(css = "li[data-title='hotels']")
	private WebElement hotelsTab;

	private SearchContext root;

	public MainBookingPanel(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select 'Hotels' tab on Main booking panel")
	public void selectHotelsTab() {
		hotelsTab.click();
	}

}
