package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginBtn.click();
		return new HomePage();
	}
}
