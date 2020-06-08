package com.crm.qa.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ClassicCRM;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage loginPage;
	ClassicCRM classicCRM;
	
	public LoginTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		intialization();
		loginPage=new LoginPage();
		classicCRM =new ClassicCRM();
	}
	
	@Test
	public void verifyLoginPageTitle()
	{
		String actualPageTitle=loginPage.getPageTitle();
		assertEquals(actualPageTitle, "Cogmento CRM", "First Page title doesn't match");
	}
	
	@Test
	public void TestInvalidUser()
	{
		loginPage.login();
		loginPage.validateInvalidUser();
		
	}
	
	@Test
	public void TestForgotPassword()
	{
		loginPage.forgotPassword();
		loginPage.verifyForgotPasswordPageHeader();
	}
	
	@Test
	public void TestClassicCRM()
	{
		loginPage.classicCRM();
		String classicCRMPageTitle=classicCRM.getClassicCRMPageTitle();
		assertEquals(classicCRMPageTitle, "CRMPRO Log In Screen", "First Page title doesn't match");
	}
	
	@Test
	public void TestSignUp()
	{
		//signUp();
		loginPage.signUp();
		loginPage.verifySignUpPageHeader();
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}