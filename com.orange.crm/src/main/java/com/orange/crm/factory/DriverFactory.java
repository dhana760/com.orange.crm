package com.orange.crm.factory;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.orange.crm.utils.ConfigReader;
import com.orange.crm.utils.LoggerUtils;

public final class DriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    // =========================================================
    // Initialize Driver
    // =========================================================

    public static void initializeDriver() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless =
                Boolean.parseBoolean(ConfigReader.get("headless"));

        logger.info(
                "Creating {} browser | headless={} | thread={}",
                browser,
                headless,
                Thread.currentThread().getId()
        );

        WebDriver webDriver = createDriver(browser, headless);

        if (!headless) {
            webDriver.manage().window().maximize();
        } else {
            webDriver.manage().window().setSize(
                    new org.openqa.selenium.Dimension(1920, 1080)
            );
        }

        driver.set(webDriver);

        logger.info(
                "{} browser created successfully for thread: {}",
                browser,
                Thread.currentThread().getId()
        );
    }

    // =========================================================
    // Create Browser
    // =========================================================

    private static WebDriver createDriver(
            String browser,
            boolean headless) {

        switch (browser) {

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                return new ChromeDriver(chromeOptions);

            case "edge":

                EdgeOptions edgeOptions =
                        new EdgeOptions();

                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }

                return new EdgeDriver(edgeOptions);

            case "firefox":

                FirefoxOptions firefoxOptions =
                        new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                return new FirefoxDriver(firefoxOptions);

            default:

                throw new IllegalArgumentException(
                        "Unsupported browser: '" + browser +
                        "'. Supported browsers: " +
                        "chrome, edge, firefox"
                );
        }
    }

    // =========================================================
    // Get Driver
    // =========================================================

    public static WebDriver getDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver == null) {

            throw new IllegalStateException(
                    "WebDriver is not initialized for thread: "
                    + Thread.currentThread().getId()
            );
        }

        return webDriver;
    }

    // =========================================================
    // Quit Driver
    // =========================================================

    public static void quitDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {

            try {

                logger.info(
                        "Closing WebDriver for thread: {}",
                        Thread.currentThread().getId()
                );

                webDriver.quit();

            } finally {

                driver.remove();
            }
        }
    }
}