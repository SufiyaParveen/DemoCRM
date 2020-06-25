package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CalendarPage extends BaseClass{

	
	public CalendarPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
