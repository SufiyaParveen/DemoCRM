package com.crm.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class SingUpTest extends BaseClass  {
	
	LoginPage loginPage;
	SignUpPage signUpPage;
	
	public SingUpTest() throws Exception
	{
		super();
	}
		
	@BeforeMethod
	public void setUp() throws Exception
	{
		intialization();
		loginPage=new LoginPage();
		signUpPage=new SignUpPage();
	}
	
	@Test 
	public void testSignUp()
	{
		loginPage.clickOnSignUpLink();
		signUpPage.registerUser();
	}
	
	@Test 
	public void testSuccessfulSignUp()
	{
		
	}	
}
