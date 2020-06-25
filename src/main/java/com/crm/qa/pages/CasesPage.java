package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CasesPage extends BaseClass{

	
	public CasesPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
