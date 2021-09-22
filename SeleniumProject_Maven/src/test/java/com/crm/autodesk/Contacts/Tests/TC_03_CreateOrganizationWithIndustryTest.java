package com.crm.autodesk.Contacts.Tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.PropertyFileUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class TC_03_CreateOrganizationWithIndustryTest {
	WebDriver driver;


	@Test

	public void createContactWithOrganization() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

		// read all the neccessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		PropertyFileUtility tLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String URL=jsonLib.readDataFromJSON("url");
		String BROWSER=jsonLib.readDataFromJSON("browser");
		String USERNAME=jsonLib.readDataFromJSON("username");
		String PASSWORD=jsonLib.readDataFromJSON("password");
		String OrgName=tLib.getPropertyFileData("Organizationname");
		tLib.getPropertyFileData("LastName");
		String Industry= tLib.getPropertyFileData("IndustryName");
		

		//String contactName = eLib.getExcelData("Leads", 1, 2);
		//String OrgName=eLib.getExcelData("Leads",1,3);

		// launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		wlib.WaitForPageLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
		

		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		// click on Organizations
		driver.findElement(By.linkText("Organizations")).click();

		// click on Create Organization
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		//Create Organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jLib.getRandomNum());
		
		//Explicit wait for element to be visible
		//wlib.WaitForPageLoad(driver);
		
		// handle the DropDown
	
		WebElement ele =driver.findElement(By.name("industry"));
		wlib.select(ele, "Education");

		//Save the Organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Logout
		WebElement ele1 =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseover(driver, ele1);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//close
		driver.close();
	

	}
}
