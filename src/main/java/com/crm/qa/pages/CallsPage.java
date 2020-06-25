package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CallsPage extends BaseClass {
	
	public CallsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

}
