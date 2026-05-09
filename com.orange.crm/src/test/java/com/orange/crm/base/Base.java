package com.orange.crm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base class for WebDriver initialization and teardown.
 * All test classes should extend this class.
 */
public class Base {

    // Thread-safe WebDriver instance for parallel execution support
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes browser before test execution.
     */
    @BeforeClass(alwaysRun = true)
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // Recommended browser configurations
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        driver.set(new ChromeDriver(options));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    /**
     * Returns the active WebDriver instance.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Closes browser after test execution.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}