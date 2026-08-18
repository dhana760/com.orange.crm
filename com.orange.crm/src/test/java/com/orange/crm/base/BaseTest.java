package com.orange.crm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.orange.crm.driver.DriverFactory;
import com.orange.crm.utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void browserStart()
	{
		driver= DriverFactory.createDriver();
		driver.get(ConfigReader.get("baseUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserStop()
	{
		if (driver != null) {
            driver.quit();
        }

	}
	public WebDriver getDriver() {
	    return driver;
	}
}
