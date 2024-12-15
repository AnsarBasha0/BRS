package com.qa.TestScript;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.Pages.Pages;
import com.qa.Utility.UtilityClass;

public class TestBase 
{
	
	static ChromeDriver driver=new ChromeDriver();
	static Pages pageFile=new Pages(driver);
	static UtilityClass  dd;
	@BeforeSuite
	public void setup() throws Exception
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown()
	{
		//driver.close();
		System.out.println("Teardown Method");
	}
	
	@BeforeTest
	public void URLCheck()
	{
		String siteURL="https://rahulshettyacademy.com/AutomationPractice/";
		String currentURL=driver.getCurrentUrl();
		assertEquals(siteURL,currentURL);
	}
	
	@BeforeClass
	public void SS() throws Exception
	{
		takeSnapShot(driver,"E://Automation_Java/BrsProject/ScreenShots/test.png") ; 
	}
	
	@AfterClass
	public void SSLast() throws Exception
	{
		takeSnapShot(driver,"E://Automation_Java/BrsProject/ScreenShots/test1.png") ; 
	}
	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
	{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}

}
