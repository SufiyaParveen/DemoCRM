package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactPage;

public class ContactsTest extends BaseClass{
	
	ContactPage contactsPage;
		
	public ContactsTest() throws Exception
	{
		super();
		
	}
		
//	@BeforeMethod
//	public void setUp() throws Exception
//	{
//		contactsPage=new ContactPage();
//	}
	
//	@Test
//	public void ValidateContactsPage_NoRecords()
//	{
//		Assert.assertEquals(contactsPage.NoRecordsFound(), "No records found");
//		System.out.println("Verified");
//	}
	
	@Test
	public void ValidateCreateContactPage() throws Exception
	{
		contactsPage=new ContactPage();
		contactsPage.CreateContactButton();
		Thread.sleep(5000);
		Assert.assertEquals(contactsPage.verifyCreateContactHeader(), "Create New Contact", "Title not matched");
		System.out.println("Create contact header text is: "+contactsPage.verifyCreateContactHeader());
	}
	
	
}
