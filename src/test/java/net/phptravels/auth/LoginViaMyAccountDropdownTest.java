package net.phptravels.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qagroup.phptravels.LoginPage;
import com.qagroup.phptravels.MainPage;
import com.qagroup.phptravels.PhpTravelsApp;
import com.qagroup.tools.CustomAssert;

public class LoginViaMyAccountDropdownTest {

	private WebDriver driver;
	private PhpTravelsApp phpTravelsApp = new PhpTravelsApp();
	private MainPage mainPage;
	private LoginPage loginPage;

	@Test
	public void testLoginViaMyAccount() {
		mainPage = phpTravelsApp.openMainPage();
		waitFor(2);
		loginPage = mainPage.navigateToLoginPage();
		waitFor(2);
		loginPage.LoginAs("user@phptravels.com", "demouser");
		waitFor(2);

		String expectedURL = "https://www.phptravels.net/account/";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "Incorrect URL:");

		WebElement userNameOnHeader = driver.findElement(By.cssSelector(".navbar .user_menu>li:nth-of-type(1)>a"));
		String actualUserNameOnHeader = userNameOnHeader.getText();
//		Assert.assertEquals(actualUserNameOnHeader.toLowerCase(), "johny", "Incorrect username: ");
		CustomAssert.assertEquals(actualUserNameOnHeader.toLowerCase(), "johny", "Username on Header should match Expected result");
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
