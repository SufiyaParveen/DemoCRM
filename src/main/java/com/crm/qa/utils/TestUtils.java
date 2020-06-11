package com.crm.qa.utils;

import org.openqa.selenium.WebElement;

public class TestUtils {

	public static long Page_Load_Time=30;
	public static long Implicit_Wait=20;
	
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
	
	
}
