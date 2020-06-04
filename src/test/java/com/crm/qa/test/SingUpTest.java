package com.crm.qa.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.SignUpPage;

public class SingUpTest extends BaseClass{
	SignUpPage signUpRef;
	public SingUpTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		preliminarySetup();
		signUpRef=new SignUpPage();
	}
	
	@Test
	public void verifyPageTitle()
	{
		String actualPageTitle=signUpRef.getPageTitle();
		assertEquals(actualPageTitle, "Cogmento CRM", "First Page title doesn't match");
	}
	
	@Test
	public void signup()
	{
		//signUp();
		signUpRef.signUp();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
