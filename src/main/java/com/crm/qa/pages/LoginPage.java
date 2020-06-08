package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class LoginPage extends BaseClass {
	
	SignUpPage signUpPage;
	
	//Object repository also called as OR
	
//	@FindBy(className="ui fluid large blue submit button")
//	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[text()='Something went wrong...']")
	WebElement invalidUserMsgText;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//h2[text()='Forgot my password']")
	WebElement forgotPasswordPageHeader;

	@FindBy(xpath="//a[text()='Classic CRM']")
	WebElement classicCRMLink;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;

	@FindBy(xpath="//h2[contains(text(),'Register')]")
	WebElement RegisterHeaderText;
	
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

//Actions: Methods/Features
	
	public void login()
	{
		TestUtils.clickOn(LoginButton);
	}
	
	public void validateInvalidUser()
	{
		String actualMsg=invalidUserMsgText.getText();
		Assert.assertEquals(actualMsg, "Something went wrong...", "Incorrect msg text is displayed");
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void forgotPassword()
	{
		TestUtils.clickOn(forgotPasswordLink);
	}
	
	public void verifyForgotPasswordPageHeader()
	{
		String ActualForgotPasswordPageHeader= TestUtils.verifyHeaderText(forgotPasswordPageHeader);
		Assert.assertEquals(ActualForgotPasswordPageHeader, "Forgot my password", "Incorrect page");
	}
	
	public void classicCRM()
	{
		TestUtils.clickOn(classicCRMLink);
	}
	
	public void signUp()
	{
		TestUtils.clickOn(signUpLink);
	}
	
	public void verifySignUpPageHeader()
	{
		String signUpPageHeader= TestUtils.verifyHeaderText(RegisterHeaderText);
		Assert.assertEquals(signUpPageHeader, "Register", "Incorrect page");
	}
}