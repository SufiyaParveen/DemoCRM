package com.crm.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ClassicCRM;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.utils.CustomListner;
import com.crm.qa.utils.TestUtils;

@Listeners(CustomListner.class)
public class LoginTest extends BaseClass{
	LoginPage loginPage;
	ClassicCRM classicCRM;
	HomePage homePage;
	SignUpPage signUpPage;
	
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
		homePage=new HomePage();
		signUpPage= new SignUpPage();
	}
	
	@Test
	public void verifyLoginPageTitle()
	{
		String actualPageTitle=TestUtils.getPageTitle();
		assertEquals(actualPageTitle, "Cogmento CRM", "First Page title doesn't match");
	}
	
	@Test
	public void TestValidLogin()
	{
		loginPage.login();
		homePage.getLoggedUser();
	}
	
	@Test
	public void TestInvalidLogin()
	{
		Assert.assertEquals(loginPage.validateInvalidUser(), "Something went wrong...", "Incorrect msg text is displayed");
	}
	
	@Test
	public void TestForgotPassword()
	{
		Assert.assertEquals(loginPage.forgotPassword(), "Forgot my password", "Incorrect page");
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
		loginPage.clickOnSignUpLink();
		Assert.assertEquals(signUpPage.verifySignUpPageHeader(), "Register", "Incorrect page");
	}
	}