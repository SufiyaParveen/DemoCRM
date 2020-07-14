package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.crm.qa.base.BaseClass;

public class TestUtils extends BaseClass{

	public static long Page_Load_Time=40;
	public static long Implicit_Wait=40;
	
	/** Clicks on Webelement 
	 * @return Nothing to be returned 
	 */
	public static void clickOn(WebElement element)
	{
		element.click();
	}
	
	/** Reads page title
	 * @return Page title as a String 
	 */	
	public static String getPageTitle()
	{
		return driver.getTitle();
	}
	
	/** Reads text of the webelement 
	 * @return Returns a String  
	 */
	public static String verifyHeaderText(WebElement headerText)
	{
		return headerText.getText();
	}
	
	/** Insert the given text in the text field 
	 * @return Nothing to be returned 
	 */
	public static void sendKeysIn(WebElement textLocation, String textToBeEntered)
	{
	textLocation.sendKeys(textToBeEntered);
	}
	
	/** Captures the screenshot of the screen and save the same in the desired folder for all the failed tests
	 * @return Nothing to be returned 
	 */
	public static void captureScreenshot(String testClassName,String testMethodName)
	{
		try
		{
		TakesScreenshot screenShot= (TakesScreenshot) driver;
		File actualScreenshot= screenShot.getScreenshotAs(OutputType.FILE);
		File destFile= new File(userDir+"\\Screenshots\\"+testClassName+"_"+testMethodName+".png");
		FileUtils.copyFile(actualScreenshot, destFile);
		} 
	
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/** Clicks on the given Menu item and initiate the respective page object
	 *<p><b>clickMenuItem("Cases") clicks on cases menu item and returns the object of Cases page</b>
	 * @return Respective Page object
	 * @throws Exception
	 */
	public static void  clickMenuItem(String menuName, List<WebElement> el) throws Exception
	{
		for(int i=0; i<el.size();i++)
		{
			if(el.get(i).getText().equals(menuName))
			{
				menuName=el.get(i).getText();
				el.get(i).click();
			}	
		}
	}
}
