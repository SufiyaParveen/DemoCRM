package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utils.TestUtils;

public class HomePage extends BaseClass {
	
	Object object;
	
// Object repository
	
	//@FindBy(className="user-display")
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loginPageHeaderText;
	
	@FindAll({@FindBy(xpath="//span[@class='item-text']")})
	List<WebElement> allMenuList;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsMenu;
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement calendarMenu;
	
	@FindBy(xpath="//div[@class='ui left fixed vertical  icon menu sidebar-dark expanded left-to-right']//span")
	WebElement homeNav;
	
	public HomePage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader()
	{
		TestUtils.clickOn(homeNav);
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
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
	
	public Object clickMenuItem(String menuName) throws Exception
	{
		for(int i=0; i<allMenuList.size();i++)
		{
			if(allMenuList.get(i).getText().equals(menuName))
			{
				menuName=allMenuList.get(i).getText();
				allMenuList.get(i).click();
				if(menuName.contains("Calendar"))
				{
					object=new CalendarPage();	
				}
				else if(menuName.contains("Contacts"))
				{
					object=new ContactPage();	
				}
				else if(menuName.contains("Companies"))
				{
					object=new CompaniesPage();	
				}
				else if(menuName.contains("Deals"))
				{
					object=new DealsPage();	
				}
				else if(menuName.contains("Tasks"))
				{
					object=new TasksPage();	
				}
				else if(menuName.contains("Cases"))
				{
					object=new CasesPage();	
				}
				else if(menuName.contains("Calls"))
				{
					object=new CallsPage();	
				}
				else if(menuName.contains("Documents"))
				{
					object=new DocumentsPage();	
				}
				else if(menuName.contains("Email"))
				{
					object=new EmailPage();	
				}
				else if(menuName.contains("Campaigns"))
				{
					object=new CampaignsPage();	
				}
				else if(menuName.contains("Forms"))
				{
					object=new FormsPage();	
				}
				break;
			}	
		}
		return object;
	}
	
	
}
