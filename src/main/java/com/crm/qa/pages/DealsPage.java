package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class DealsPage extends BaseClass{

	public DealsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
