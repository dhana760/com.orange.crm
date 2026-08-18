package com.orange.crm.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private DriverFactory() {
        // Prevent object creation
    }

    public static WebDriver createDriver() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        return driver;
    }
}
