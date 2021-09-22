package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility 
{
  WebDriver driver;
  public CreateOrganizationPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  //locate the elements
  @FindBy(name="accountname")
  private WebElement OrgNameEdt;
  
  @FindBy(name="industry")
  private WebElement industryDropdown;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
public WebElement getOrgNameEdt() {
	return OrgNameEdt;
}

public WebElement getIndustryDropdown() {
	return industryDropdown;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}
	//Business Standards
public void createOrganization(String Orgname)
{
	OrgNameEdt.sendKeys(Orgname);
	SaveBtn.click();
}
public void createOrganizationWithIndustry(String Orgname,String indType)
{
	OrgNameEdt.sendKeys(Orgname);
	select(industryDropdown,indType);
	SaveBtn.click();
}
}
