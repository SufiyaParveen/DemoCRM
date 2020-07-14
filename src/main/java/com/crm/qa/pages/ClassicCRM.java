package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class ClassicCRM extends BaseClass {

	
	public ClassicCRM() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

	public String getClassicCRMPageTitle()
	{
		return driver.getTitle();
	}
}
