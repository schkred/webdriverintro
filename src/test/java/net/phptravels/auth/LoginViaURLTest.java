package net.phptravels.auth;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qagroup.phptravels.AccountPage;
import com.qagroup.phptravels.LoginPage;
import com.qagroup.phptravels.PhpTravelsApp;
import com.qagroup.tools.CustomAssert;

import io.qameta.allure.*;

@Epic("Authentication")
@Feature("Login")
@Story("Direct login")
public class LoginViaURLTest {

	private PhpTravelsApp phpTravelsApp = new PhpTravelsApp();
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Link("https://www.google.com/drive/")
	@Test
	public void testLoginViaURL() {
		loginPage = phpTravelsApp.openLoginPage();
		waitFor(2);
		accountPage = loginPage.LoginAs("user@phptravels.com", "demouser");
		waitFor(2);

		String actualURL = accountPage.getCurrentUrl();
		String expectedURL = "https://www.phptravels.net/account/";

		Assert.assertEquals(actualURL, expectedURL, "Incorrect URL: ");

		String actualUserNameOnHeader = accountPage.readUsername();
		// Assert.assertEquals(actualUserNameOnHeader.toLowerCase(), "johny", "Incorrect
		// username: ");
		CustomAssert.assertEquals(actualUserNameOnHeader.toLowerCase(), "johny",
				"Username on Header should match Expected result");
	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		phpTravelsApp.close();
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
