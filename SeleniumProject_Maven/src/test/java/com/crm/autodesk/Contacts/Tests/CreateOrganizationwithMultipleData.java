package com.crm.autodesk.Contacts.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.ObjectRepositary.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepositary.OrganizationPage;

public class CreateOrganizationwithMultipleData extends BaseClass {
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("Sheet1");
		
	}
	@Test(dataProvider="getData")
	public void CreateOrganizationwithMultipleData(String OrgName,String IndType)
	{
		//navigate To Organization
		HomePage Hp = new HomePage(driver);
		Hp.clickOrgLnk();
		
		OrganizationPage Op = new OrganizationPage(driver);
		Op.ClickOnCreateOrganizatio();
		
		CreateOrganizationPage cc = new CreateOrganizationPage(driver);
		cc.createOrganizationWithIndustry(OrgName+jLib.getRandomNum(), IndType);
		
		OrganizationInfoPage dd = new OrganizationInfoPage(driver);
		dd.waitforupdate(driver);
		
	}
	

}
