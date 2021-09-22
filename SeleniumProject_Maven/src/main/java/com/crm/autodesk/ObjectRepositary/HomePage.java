package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
		WebDriver driver;
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administatorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signoutLnk;
		
		public WebDriver getDriver() {
			return driver;
		}
		@FindBy(linkText="Contacts")
		private WebElement contactsLnk;
		//generate getters
		

		public WebElement getAdministatorImg() {
			return administatorImg;
		}
		WebDriverUtility Wv = new WebDriverUtility();
		public void mouseoverAdminstrator(WebDriver driver,WebElement element)
		{
			Wv.mouseover(driver, administatorImg);
		}

		
		public WebElement getSignoutLnk() 
		{
			return signoutLnk;
		}


		public WebElement getContactsLnk() 
		{
			return contactsLnk;
		}
		
		//provide business logic
		public void clickOnContacts() 
		{
			contactsLnk.click();
		}
		public void clickOnSignOut(WebDriver driver)
		{
			waitForElementVisibility(driver, administatorImg);
			mouseover(driver, administatorImg);
			signoutLnk.click();
		}
		@FindBy(linkText="Organizations")
		private WebElement OrganizationLnk;
		
		public WebElement getOrganizationLnk() 
		{
			return OrganizationLnk;
		}
		public void clickOrgLnk()
		{
			OrganizationLnk.click();
		}
		
		
		

}
