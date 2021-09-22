package com.crm.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

public class TC_01_CreateContactWithoutLastNameTest extends BaseClass
{
	

	@Test(groups="SmokeSuite")

	public void createContactWithoutLastName() throws Throwable {

		

		String contactName = eLib.getExcelData("Leads", 1, 2);
		String OrgName=eLib.getExcelData("Leads",1,3);

		
		HomePage Hp = new HomePage(driver);
		Hp.clickOnContacts();
		
		ContactPage Cp = new ContactPage(driver);
		Cp.ClickonCreateContacts();
		
		CreateContactPage Cc= new CreateContactPage(driver);
		Cc.clickonSave();
		String acx=wlib.FetchMsgAlert(driver);
		System.out.println(acx);
		wlib.acceptAlert(driver);
		
		
	

}
}