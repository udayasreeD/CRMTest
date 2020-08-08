package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement userLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyUserName() {
		return userLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactslink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTaskslink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public DealsPage clickOnDealslink() {
		dealsLink.click();
		return new DealsPage();
	}

	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
}
