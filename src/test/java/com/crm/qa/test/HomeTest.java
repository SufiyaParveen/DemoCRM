package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomeTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	
	public HomeTest() throws Exception
	{
		super();
	}
		
	@BeforeMethod
	public void setUp() throws Exception
	{
		intialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		loginPage.login();
	}
	
	@Test
	public void validateUser() throws Exception
	{
		String actulLoginPageHeaderText=homePage.getLoggedUser();
		Assert.assertEquals(actulLoginPageHeaderText, "vibha gupta", "Incorrect msg text is displayed");
	}
	
	@Test
	public void validateMenuList()
	{
		homePage.getMenuList();
	}
	
	@Test
	public void clickOnMenu()
	{
		homePage.clickMenuItem("Forms");	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
