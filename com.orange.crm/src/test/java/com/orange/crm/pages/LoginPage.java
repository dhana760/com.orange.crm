package com.orange.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void enterUsername(String username) {

        wait.waitForElement(this.username)
            .sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.waitForElement(this.password)
            .sendKeys(password);
    }

    public void clickLogin() {

        wait.waitForClickability(loginButton);
        driver.findElement(loginButton).click();
    }
}