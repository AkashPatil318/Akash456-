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
import com.crm.autodesk.ObjectRepositary.ContactInformationPage;
import com.crm.autodesk.ObjectRepositary.ContactPage;
import com.crm.autodesk.ObjectRepositary.CreateContactPage;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LoginPage;

public class TC_04_CreateContactClickonReportTest extends BaseClass
	{
		

		@Test(groups="RegressionSuite")

		public void CreateContactClickonReportTest() throws Throwable 
		{

			
			

			String contactName = eLib.getExcelData("Leads", 1, 2);
			String OrgName=eLib.getExcelData("Leads",1,3);

	
			HomePage Hp = new HomePage(driver);
			Hp.clickOnContacts();
			
			ContactPage Cp = new ContactPage(driver);
			Cp.ClickonCreateContacts();
			
			CreateContactPage Cv =new CreateContactPage(driver);
			Cv.createContact(contactName);
			Cv.ClickOnRepName();
			Thread.sleep(3000);
			wlib.switchToWindow(driver, "Popup");
			Thread.sleep(2000);
			Cv.ClickonExsRep();
			
			wlib.switchToWindow(driver, "Contacts");
			Cv.clickonSave();
			
			ContactInformationPage Ci = new ContactInformationPage(driver);
			String Update=Ci.ClickonConInfDis();
			System.out.println(Update);
			 String Info=Ci.ClickonUpd();
			 System.out.println(Info);
			 
			 

}
	}
