package com.qa.TestScript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.qa.Utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.*;

public class Login extends TestBase
{
	Pages PageFile;

	//@Test(dataProvider = "getData")
	public static void method1(String name) throws Exception
	{
		WebElement table = pageFile.getFixedTable();
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) 
		{
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell:cells)
			{
				
				if(cell.getText().contains(name))
				{
					System.out.println(cell.getText());
					
				}
			}
		}
	}

	@Test
	public static void method2() throws InterruptedException 
	{
		pageFile.getSelectRadioBtn().click();
		pageFile.getSuggestionBox().sendKeys("India",Keys.TAB);
		pageFile.getDropdown().click();
		pageFile.getCheckBox().click();
		pageFile.getOpentab().click();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		pageFile.getnewTabcource().click();

	}
	
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile="E:\\Automation_Java\\BrsProject\\ExcelSheet\\dataSheet.xlsx";
		String xSheet="Sheet1";
		int rowCount=UtilityClass.getRowCount(xFile, xSheet);
		int cellCount=UtilityClass.getCellCount(xFile, xSheet, rowCount);

		String[][] data=new String[rowCount][cellCount];	

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=UtilityClass.getCellData(xFile, xSheet, i, j);  
			}
		}

		return data;
	}
}