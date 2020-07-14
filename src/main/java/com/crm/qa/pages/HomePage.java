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
	
	/** Fetches current URL 
	 * @return Current URL as a String  
	 */
	public String getPageHeader()
	{
		TestUtils.clickOn(homeNav);
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
	
	/** Fetches the logged in user name
	 * @return User name as a String  
	 */
	public String getLoggedUser()
	{
		return loginPageHeaderText.getText();
	}

	/** Reads and prints all the listed Menu items in the Navigation bar 
	 * @return Nothing to be returned
	 */
	public void getMenuList()
	{
		for(int i=0; i<allMenuList.size(); i++)
		{
			System.out.println(allMenuList.get(i).getText());
		}
	}
	
	
	
	
}
