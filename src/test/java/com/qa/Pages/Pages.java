package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages 
{
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input")
	WebElement SelectRadioBtn;
	public WebElement getSelectRadioBtn()
	{
		return SelectRadioBtn;
	}
	
	@FindBy(id = "autocomplete")
	WebElement SuggestionBox;
	public WebElement getSuggestionBox()
	{
		return SuggestionBox;
	}
	@FindBy(xpath = "//*[@id=\"dropdown-class-example\"]/option[4]")
	WebElement Dropdown;
	public WebElement getDropdown()
	{
		return Dropdown;
	}
	@FindBy(id="checkBoxOption1")
	WebElement CheckBox;
	public WebElement getCheckBox()
	{
		return CheckBox;
	}
	@FindBy(id = "opentab")
	WebElement Opentab;
	public WebElement getOpentab()
	{
		return Opentab;
	}
	
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
	WebElement newTabcource;
	public WebElement getnewTabcource()
	{
		return newTabcource;
	}
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/fieldset[2]/div[1]/table/tbody")
	WebElement FixedTable;
	public WebElement getFixedTable()
	{
		return FixedTable;
	}
	
	public Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	

}
