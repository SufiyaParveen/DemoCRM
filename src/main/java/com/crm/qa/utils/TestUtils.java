package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.BaseClass;

public class TestUtils extends BaseClass{

	public static long Page_Load_Time=40;
	public static long Implicit_Wait=40;
	
	public static void clickOn(WebElement element)
	{
		element.click();
	}
	
	public static String verifyHeaderText(WebElement headerText)
	{
		return headerText.getText();
	}
	
	public static void sendKeysIn(WebElement textLocation, String textToBeEntered)
	{
	textLocation.sendKeys(textToBeEntered);
	}
	
	public static void captureScreenshot(String testClassName,String testMethodName)
	{
	
		try
		{
		TakesScreenshot screenShot= (TakesScreenshot) driver;
		File actualScreenshot= screenShot.getScreenshotAs(OutputType.FILE);
		String userDir=System.getProperty("user.dir");
		File destFile= new File(userDir+"\\Screenshots\\"+testClassName+"_"+testMethodName+".png");
		FileUtils.copyFile(actualScreenshot, destFile);
		} 
	
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
