package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage
{
	  public ContactPage(WebDriver driver) 
	   {
		PageFactory.initElements(driver, this);
	   }
		  	@FindBy(xpath="//img[@alt='Create Contact...']")
		  	private WebElement createContactImg;
		  	
		  	//getters
			public WebElement getCreateContactImg() {
				return createContactImg;
			}
				//Business Standards
				public void ClickonCreateContacts()
				{
				  createContactImg.click();
				}

}
