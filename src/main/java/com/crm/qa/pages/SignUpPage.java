package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class SignUpPage extends BaseClass {
	
	//Object repository also called as OR
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUpLink;

	public SignUpPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions: Methods/Features
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void signUp()
	{
		//clickOn(SignUpLink);
		SignUpLink.click();
	}


}
