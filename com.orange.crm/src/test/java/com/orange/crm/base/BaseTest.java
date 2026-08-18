package com.orange.crm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.orange.crm.driver.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void browserStart()
	{
		driver= DriverFactory.createDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserStop()
	{
		if (driver != null) {
            driver.quit();
        }

	}
}
