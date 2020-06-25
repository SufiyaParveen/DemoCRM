package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class LoginPage extends BaseClass {
	
	SignUpPage signUpPage;
	HomePage homePage;
	ClassicCRM classicCRM;
	
//Object repository also called as OR
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
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

	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

//Actions: Methods/Features
	
	public void login()
	{
		TestUtils.sendKeysIn(emailTextbox, propertiesFile.getProperty("email"));
		TestUtils.sendKeysIn(passwordTextbox, propertiesFile.getProperty("password"));
		TestUtils.clickOn(LoginButton);
	}
	
	public void validateInvalidUser()
	{
		TestUtils.clickOn(LoginButton);
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
		String ActualForgotPasswordPageHeader= TestUtils.verifyHeaderText(forgotPasswordPageHeader);
		Assert.assertEquals(ActualForgotPasswordPageHeader, "Forgot my password", "Incorrect page");
	}
	
	public void classicCRM()
	{
		TestUtils.clickOn(classicCRMLink);
		
	}
	
	public void clickOnSignUpLink()
	{
		TestUtils.clickOn(signUpLink);
	}
	
	
}