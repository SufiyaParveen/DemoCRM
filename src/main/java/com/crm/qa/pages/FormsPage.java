package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class FormsPage extends BaseClass{
	
	public FormsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
