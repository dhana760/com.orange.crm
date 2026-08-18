package com.orange.crm.test;

import org.testng.annotations.Test;

import com.orange.crm.base.BaseTest;
import com.orange.crm.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
    }
}