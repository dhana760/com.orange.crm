package com.orange.crm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orange.crm.base.BaseTest;
import com.orange.crm.data.LoginData;
import com.orange.crm.listeners.TestListener;
import com.orange.crm.pages.LoginPage;
import com.orange.crm.retry.RetryAnalyzer;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	/**
     * @param username
     * @param password
     */
	@Test(
		    dataProvider = "loginData",
		    dataProviderClass = LoginData.class,
		    retryAnalyzer = RetryAnalyzer.class
		)
		public void validLoginTest(
		        String username,
		        String password) {

		    LoginPage loginPage =
		            new LoginPage(getDriver());

		    loginPage.enterUsername(username);
		    loginPage.enterPassword(password);
		    loginPage.clickLogin();
		}
}