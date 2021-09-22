package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ConInfDis;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement UpdDis;
	
	public WebElement getConInfDis()
	{
		return ConInfDis;
	}
	public WebElement getUpdDis()
	{
		return UpdDis;
	}
	public String ClickonConInfDis()
	{
		return ConInfDis.getText();
	}
	public String ClickonUpd() {
		return UpdDis.getText();
	}
	

	
	

}
