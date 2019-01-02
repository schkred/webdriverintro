package net.phptravels.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginViaMyAccountDropdown {
	
	private FirefoxDriver driver;

	@Test
	public void testLoginViaMyAccount() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://www.phptravels.net/");
		
		WebElement myAccountButton = driver.findElement(By.cssSelector(".navbar #li_myaccount"));
		myAccountButton.click();
		
		WebElement myAccountDropdown = driver.findElement(By.cssSelector(".navbar #li_myaccount .dropdown-menu"));
		
		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(text(), 'Login')]"));
		loginOption.click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
