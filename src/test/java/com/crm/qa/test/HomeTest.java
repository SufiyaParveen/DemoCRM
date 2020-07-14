package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.CustomListner;

@Listeners(CustomListner.class)
public class HomeTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	CalendarPage calendarPage;
	
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
	public void validateHomePage()
	{
		loginPage.login();
		String HomeURL=homePage.getPageHeader();
		System.out.println(HomeURL);
		Assert.assertEquals(HomeURL, "https://ui.cogmento.com/home");
	}
	
	@Test
	public void validateUser() throws Exception
	{
		String actulLoginPageHeaderText=homePage.getLoggedUser();
		Assert.assertEquals(actulLoginPageHeaderText, "Test User", "Incorrect msg text is displayed");
	}
	
	@Test
	public void validateMenuList()
	{
		homePage.getMenuList();
	}
}