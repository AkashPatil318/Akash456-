package com.crm.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.PropertyFileUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;
import com.crm.autodesk.ObjectRepositary.ContactPage;
import com.crm.autodesk.ObjectRepositary.CreateContactPage;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LoginPage;

public class TC_05_CreateContactImportTest extends BaseClass {
	

	@Test(groups="SmokeSuite")

	public void CreateContactImportTest() throws Throwable 
	{

		

		String contactName = eLib.getExcelData("Leads", 1, 2);
		String OrgName=eLib.getExcelData("Leads",1,3);

		HomePage Hp = new HomePage(driver);
		Hp.clickOnContacts();
		
		ContactPage Cp = new ContactPage(driver);
		Cp.ClickonCreateContacts();
		
		CreateContactPage Cv =new CreateContactPage(driver);
		Cv.createContact(contactName);
		Cv.ClickonImport();
		Cv.SelectImpFile();
		Cv.ClickonNext();
	
		Cv.selectDropdown(4);
		Cv.clickOnimport();
		
		
}
}
