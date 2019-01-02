package com.qagroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.javafaker.Faker;

public class WebDriverInterfaceDemo {

	public static void main(String[] args) {
		WebDriver driver = startWebDriver();
		driver.get("https://www.phptravels.net/");

		// System.out.println(new Faker().chuckNorris().fact());

	}

	public static WebDriver startWebDriver() {
		int rand = new Faker().number().numberBetween(0, 1);
		switch (rand) {
		case 0:
			return new ChromeDriver();
		default:
			return new FirefoxDriver();
		}

	}
}
