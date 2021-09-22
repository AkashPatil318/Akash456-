package com.crm.autodesk.Contacts.Tests;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.OrganizationPage;

public class CreateOrganizarionCaptureTitle extends BaseClass{
	@Test
	public void CreateOrganizarionCaptureTitle()
	{
		
	
	HomePage Hp = new HomePage(driver);
	Hp.clickOrgLnk();
	OrganizationPage Op = new OrganizationPage(driver);
	String text=Op.HoverMsg();
	System.out.println(text);

}
}