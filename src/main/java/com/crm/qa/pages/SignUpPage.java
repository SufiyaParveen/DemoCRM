package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class SignUpPage extends BaseClass {
	
	@FindBy(xpath="//h2[contains(text(),'Register')]")
	WebElement RegisterHeaderText;
	

	public SignUpPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifySignUpPageHeader()
	{
		String signUpPageHeader= TestUtils.verifyHeaderText(RegisterHeaderText);
		Assert.assertEquals(signUpPageHeader, "Register", "Incorrect page");
	}
	
	
}
