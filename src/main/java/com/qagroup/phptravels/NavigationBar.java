package com.qagroup.phptravels;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar {

	@FindBy(xpath="//li [a/text()='Home']")
	private WebElement homeTab;
	
	private SearchContext root;
	
	public NavigationBar(WebDriver root) {
		this.root = root;
	}
	
}
