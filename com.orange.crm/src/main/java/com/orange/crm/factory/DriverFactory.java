package com.orange.crm.factory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.orange.crm.utils.LoggerUtils;

public final class DriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initializeDriver() {

        logger.info("Creating WebDriver for thread: {}",
                Thread.currentThread().getId());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        driver.set(webDriver);

        logger.info("WebDriver created successfully");
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {

            logger.info(
                    "Closing WebDriver for thread: {}",
                    Thread.currentThread().getId()
            );

            webDriver.quit();

            driver.remove();
        }
    }
}