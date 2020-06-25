package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class EmailPage extends BaseClass{

	public EmailPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
