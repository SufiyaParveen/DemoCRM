package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CampaignsPage extends BaseClass {
	
	public CampaignsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

}
