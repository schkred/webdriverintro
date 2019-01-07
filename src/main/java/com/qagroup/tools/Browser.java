package com.qagroup.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	private static WebDriver driver;

	public static WebDriver open() {
		WebDriver driver = startBrowser();
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver startBrowser() {
		String browser = System.getProperty("browser");
		if (browser == null || "firefox".equals(browser.toString())) {
			driver = startFirefox();
		} else if ("chrome".equals(browser.toString())) {
			driver = startChrome();
		} else
			throw new RuntimeException("\nUnsupported driver for browser " + browser + "\n");
		return driver;
	}

	private static WebDriver startChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		return new ChromeDriver();
	}

	private static WebDriver startFirefox() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("disable-infobars");
		return new FirefoxDriver();
	}

	// public static WebDriver open() {
	// String browser = System.getProperty("browser");
	// switch (browser) {
	// case "chrome":
	// WebDriverManager.chromedriver().setup();
	// WebDriver chromeDriver = new ChromeDriver();
	// chromeDriver.manage().window().maximize();
	// return chromeDriver;
	// case "ie":
	// WebDriverManager.iedriver().setup();
	// WebDriver ieDriver = new InternetExplorerDriver();
	// ieDriver.manage().window().maximize();
	// return ieDriver;
	// case "edge":
	// WebDriverManager.edgedriver().setup();
	// WebDriver edgeDriver = new EdgeDriver();
	// edgeDriver.manage().window().maximize();
	// return edgeDriver;
	//// case "firefox":
	//// WebDriverManager.firefoxdriver().setup();
	//// WebDriver firefoxDriver = new FirefoxDriver();
	//// return firefoxDriver;
	// default:
	// WebDriverManager.firefoxdriver().setup();
	// WebDriver firefoxDriver = new FirefoxDriver();
	// firefoxDriver.manage().window().maximize();
	// return firefoxDriver;
	// }
	// }
}
