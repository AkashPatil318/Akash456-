package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility
{
  public OrganizationInfoPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  @FindBy(xpath="//span[contains(text(),'Updated ')]")
  private WebElement waitforupdate;
  
public WebElement getWaitforupdate() 
{
	return waitforupdate;
}
public void waitforupdate(WebDriver driver) 
{
	waitForElementVisibility(driver, waitforupdate);
	
}
}
