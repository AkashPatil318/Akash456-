package com.crm.autodesk.Contacts.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.PropertyFileUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;
@Listeners(com.crm.autodesk.GenericUtils.Listeners.class)
public class TC_01_CreateContactWithOrganizationTest extends BaseClass {

	@Test(retryAnalyzer=com.crm.autodesk.GenericUtils.RetryAnalyser.class)


	public void createContactWithOrganization() throws Throwable {

		

		

		String contactName = eLib.getExcelData("Leads", 1, 2);
		String OrgName=eLib.getExcelData("Leads",1,3);

		
		

		
		// click on Contacts
		driver.findElement(By.linkText("Contacts")).click();

		// click on Create Contacts
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		//Create Contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		// switch to child  window
		wlib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("EDFG Group Limited")).click();

		// switch to Parent Window
		wlib.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+]']")).click();

		

	}
}
