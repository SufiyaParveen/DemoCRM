package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties propertiesFile;
	public static WebDriver driver;
	public static String userDir=System.getProperty("user.dir");
	
	LoginPage loginPage;
	
	public BaseClass()
	{
			try {
			propertiesFile=new Properties();
			FileInputStream ip=new FileInputStream(userDir+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			propertiesFile.load(ip);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public void intialization()
	{
		String browserName=propertiesFile.getProperty("browser");
			
		if (browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		// 	System.setProperty("webdriver.gecko.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
		//	System.setProperty("webdriver.ie.driver", "C:\\Users\\sufiyap\\eclipse-workspace\\DemoCRM\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.get(propertiesFile.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void setUp() throws Exception
	{
		intialization();
		loginPage=new LoginPage();
		loginPage.login();
	}	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
