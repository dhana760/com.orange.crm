package com.orange.crm.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orange.crm.factory.DriverFactory;
import com.orange.crm.utils.ConfigReader;
import com.orange.crm.utils.LoggerUtils;

public class BaseTest {

    private static final Logger logger =
            LoggerUtils.getLogger(BaseTest.class);

    @BeforeMethod
    public void browserStart() {

        logger.info("Starting browser");

        DriverFactory.initializeDriver();

        getDriver().get(
                ConfigReader.get("baseUrl")
        );

        logger.info("Application opened");
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {

        logger.info("Stopping browser");

        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {

        return DriverFactory.getDriver();
    }
}