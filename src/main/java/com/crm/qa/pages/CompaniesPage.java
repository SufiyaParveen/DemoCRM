package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CompaniesPage extends BaseClass {

	public CompaniesPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
}
