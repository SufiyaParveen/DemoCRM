package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass {
	
// Object repository
	
	//@FindBy(className="user-display")
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loginPageHeaderText;
	
	@FindAll({@FindBy(xpath="//span[@class='item-text']")})
	List<WebElement> allMenuList;
	
	public HomePage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoggedUser()
	{
		return loginPageHeaderText.getText();
	}

	public void getMenuList()
	{
		for(int i=0; i<allMenuList.size(); i++)
		{
			System.out.println(allMenuList.get(i).getText());
		}
	}
	
	public void clickMenuItem(String menuName)
	{
		for(int i=0; i<allMenuList.size();i++)
		{
			if(allMenuList.get(i).getText().contains(menuName))
			{
				allMenuList.get(i).click();
				break;
			}
			
		}
	}
	
}
