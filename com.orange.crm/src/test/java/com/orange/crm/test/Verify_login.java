package com.orange.crm.test;

import org.testng.annotations.Test;

import com.orange.crm.base.Base;
import com.orange.crm.pages.LoginPage;

public class Verify_login extends Base {
	
	LoginPage verifyLogin;
	@Test
	void verifyLogin() throws InterruptedException
	{
		verifyLogin= new LoginPage(getDriver());
		verifyLogin.loginflow("Admin","admin123");
	
	}
}
