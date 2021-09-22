package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
  	private WebElement createOrgImg;
	
	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}
	//Business Standards
	public void ClickOnCreateOrganizatio()
	{
		createOrgImg.click();
	}
	public String HoverMsg()
	{
		String hmsg=createOrgImg.getAttribute("title");
		return hmsg;
		
	}
}
