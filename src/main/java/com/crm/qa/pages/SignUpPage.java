package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class SignUpPage extends BaseClass {
	
	@FindBy(xpath="//h2[contains(text(),'Register')]")
	WebElement RegisterHeaderText;
	
	//@FindBy(name="action")
	@FindBy(xpath="//button[@name='action']")
	WebElement signUpButton;

	public SignUpPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	/** Reads SignUp page header text
	 * 
	 * @return SignUp page header text as String 
	 */
	public String verifySignUpPageHeader()
	{
		String signUpPageHeader= TestUtils.verifyHeaderText(RegisterHeaderText);
		return signUpPageHeader;
		
	}
	/** Clicks on Register User link   
	 * @return Nothing to be returned 
	 */
	public void registerUser()
	{
		TestUtils.clickOn(signUpButton);
	}
	
}
