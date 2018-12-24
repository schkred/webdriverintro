package com.qagroup;

import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverStart {

	public static void main(String[] args) {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SYurivych\\eclipse-workspace\\WebDrivers\\geckodriver.exe");
		FirefoxDriver ffdriver = new FirefoxDriver();
		ffdriver.get("https://www.phptravels.net/");
		
	}
}
