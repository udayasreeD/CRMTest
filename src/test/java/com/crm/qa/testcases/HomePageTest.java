package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{ 
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	TasksPage taskspage;
	DealsPage dealspage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialise();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		taskspage = new TasksPage();
		dealspage = new DealsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@Test(priority = 1)
	public void homePageTitleTest() {
		String homPageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homPageTitle, "CRMPRO", "Expected title is not matching");
	}
	
	@Test(priority = 2)
	public void userNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test
	public void contactsLinkTest() {
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactslink();
	}
	
	@Test
	public void tasksLinkTest() {
		testutil.switchToFrame();
		taskspage = homepage.clickOnTaskslink();
	}
	
	@Test
	public void dealsLinkTest() {
		testutil.switchToFrame();
		dealspage = homepage.clickOnDealslink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
