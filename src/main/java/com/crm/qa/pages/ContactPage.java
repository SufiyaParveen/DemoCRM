package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class ContactPage extends BaseClass{
	
	@FindBy(xpath="//span/p[text()='No records found']")
	WebElement NoRecordFoundText;
	
	@FindBy(xpath="//button[text()='Newbbb']")
	WebElement CreateContactButton;
	
	@FindBy(xpath="//div[contains(text(),'Create New Contact')]")
	
	//div[@class='ui header item mb5 light-black']
	WebElement CreateContactPageHeaderText;
	
	public ContactPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
//	public String NoRecordsFound()
//	{
//		
//		String ActualText=TestUtils.verifyHeaderText(NoRecordFoundText);
//		return ActualText;
//		
//	}
//	
	public void CreateContactButton()
	{
		
		TestUtils.clickOn(CreateContactButton);
		
	}
	
	public String verifyCreateContactHeader()
	{
		System.out.println("Test verified Sar kharab horaha abh");
		String CreateContactHeader=TestUtils.verifyHeaderText(CreateContactPageHeaderText);
		return CreateContactHeader;
	}
	
}
