package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class TasksPage extends BaseClass{

	
	public TasksPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
}
