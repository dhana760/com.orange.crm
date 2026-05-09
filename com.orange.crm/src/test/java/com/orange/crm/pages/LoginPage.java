package com.orange.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "username")
	 WebElement username;
	
	@FindBy(how = How.NAME, using = "password")
	 WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[normalize-space()=\"Login\"]")
	 WebElement loginBtn;
	
	public void loginflow(String uname, String upass)
	{
		username.sendKeys(uname);
		password.sendKeys(upass);
		loginBtn.click();
	}

}
