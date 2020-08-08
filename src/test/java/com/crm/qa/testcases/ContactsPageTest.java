package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialise();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactslink();
		
	}
	
	@Test(priority = 1)
	public void contactsLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contact label is missing");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(dataProvider = "getCRMTestData" )
	public void newContactTest(String title,String firstname,String lastname,String company) {
		homepage.clickOnNewContact();
		contactspage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
