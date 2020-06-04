package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utils.TestUtils;

public class BaseClass {

	Properties propertiesFile;
	public static WebDriver driver;
	public BaseClass() throws IOException
	{
		propertiesFile=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		propertiesFile.load(ip);
	}
		
	public void preliminarySetup()
	{
		String browserName=propertiesFile.getProperty("browser");
		//String url=propertiesFile.getProperty("url");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.get(propertiesFile.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
		
	}
}
