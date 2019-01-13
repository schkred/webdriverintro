package com.qagroup.tools;

import org.testng.Assert;

import io.qameta.allure.Step;


public class CustomAssert {

	@Step("Actual and Expected should match: \nactual: {0}\nexpected: {1}")
	public static void assertEquals(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}
}
