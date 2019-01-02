package net.phptravels.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginViaURLTest {
	private FirefoxDriver driver;
	
	@Test
	public void testLoginViaURL() {
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		driver.get("https://www.phptravels.net/login");
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys("user@phptravels.com");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("demouser");
		WebElement loginButton = driver.findElement(By.cssSelector(".loginbtn"));
		loginButton.click();
		
		waitFor(2);
		
		String expectedURL = "https://www.phptravels.net/account/";
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL, "Incorrect URL:");
		
	}
	
	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
