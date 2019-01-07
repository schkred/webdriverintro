package net.phptravels.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qagroup.tools.Browser;

public class LoginViaMyAccountDropdownTest {

	private WebDriver driver;

	@Test
	public void testLoginViaMyAccount() {
		driver = Browser.open();

		driver.get("https://www.phptravels.net/");

		WebElement myAccountButton = driver.findElement(By.cssSelector(".navbar #li_myaccount"));
		myAccountButton.click();

		WebElement myAccountDropdown = driver.findElement(By.cssSelector(".navbar #li_myaccount .dropdown-menu"));

		WebElement loginOption = myAccountDropdown.findElement(By.xpath(".//a[contains(text(), 'Login')]"));
		loginOption.click();

		waitFor(2);

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

		WebElement userNameOnHeader = driver.findElement(By.cssSelector(".navbar .user_menu>li:nth-of-type(1)>a"));
		String actualUserNameOnHeader = userNameOnHeader.getText();

		Assert.assertEquals(actualUserNameOnHeader.toLowerCase(), "johny", "Incorrect username: ");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
