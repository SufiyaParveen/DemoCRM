package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

	

public class ContactsTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactsPage;
		
	
	public ContactsTest() throws Exception
	{
		super();
	}
		
	@BeforeMethod
	public void setUp() throws Exception
	{
		intialization();
		loginPage=new LoginPage();
		loginPage.login();
			
		homePage=new HomePage();
	
		String readMenuItem; 
		
		readMenuItem=propertiesFile.getProperty("menuItem");	
		if(readMenuItem.equalsIgnoreCase("Contacts"))
		{
			homePage.clickMenuItem(readMenuItem);	
		}
		else 
		{
			readMenuItem="Contacts";
			homePage.clickMenuItem(readMenuItem);	
		}
		
		contactsPage=new ContactPage();
	}
	
//	@Test
//	public void ValidateContactsPage_NoRecords()
//	{
//		Assert.assertEquals(contactsPage.NoRecordsFound(), "No records found");
//		System.out.println("Verified");
//	}
	
	@Test
	public void ValidateCreateContactPage() throws InterruptedException
	{
		contactsPage.CreateContactButton();
		Thread.sleep(5000);
	Assert.assertEquals(contactsPage.verifyCreateContactHeader(), "Create New Contact", "Title not matched");
		System.out.println(contactsPage.verifyCreateContactHeader());
	}
	
	
	@AfterMethod
	public void teardown()
	{
	//	driver.quit();
	}

}
