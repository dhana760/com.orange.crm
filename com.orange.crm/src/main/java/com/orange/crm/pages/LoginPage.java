package com.orange.crm.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orange.crm.utils.LoggerUtils;
import com.orange.crm.utils.WaitUtils;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils wait;

    private final By username =
            By.name("username");

    private final By password =
            By.name("password");

    private final By loginButton =
            By.xpath("//button[@type='submit']");
    
    private static final Logger logger =
            LoggerUtils.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void enterUsername(String username) {

    	logger.info("Entering username");
        wait.waitForElement(this.username)
            .sendKeys(username);
    }

    public void enterPassword(String password) {

    	logger.info("Entering password");
        wait.waitForElement(this.password)
            .sendKeys(password);
    }

    public void clickLogin() {

    	logger.info("Clicking Login button");
        wait.waitForClickability(loginButton);
        driver.findElement(loginButton).click();
    }
}