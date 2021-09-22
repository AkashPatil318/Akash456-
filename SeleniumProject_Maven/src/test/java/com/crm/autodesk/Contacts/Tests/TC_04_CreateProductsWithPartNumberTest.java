package com.crm.autodesk.Contacts.Tests;

import java.util.List;

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

public class TC_04_CreateProductsWithPartNumberTest {
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
		//tLib.getPropertyFileData("LastName");
		//String Industry= tLib.getPropertyFileData("IndustryName");
		
		
		String ProductName = eLib.getExcelData("product", 1, 3);
		String ProductCode=eLib.getExcelData("product",1,2);
		
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
		driver.findElement(By.linkText("Products")).click();

		// click on Create Products
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		
		//Create Product Name
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.id("productcode")).sendKeys(ProductCode);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//fetch product part number
		String num=driver.findElement(By.id("dtlview_Part Number")).getText();
		
		//String num=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[2]")).getText();
		//System.out.println(num);
		//click on Products
		driver.findElement(By.partialLinkText("Products")).click();
		//driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(ProductCode);
		// click on Search  for  INBox
		WebElement ele =driver.findElement(By.id("bas_searchfield"));
		wlib.select(ele,"Part Number");
		
		//driver.findElement(By.id("//option[@value='productcode']")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(num);
		driver.findElement(By.name("submit")).click();
		
		// Validate product Number
		if
		(ProductCode.equals(num)){
			System.out.println("Number is matching with:"+num);
		}else {
			System.out.println("Number is not matching");
			
		}
		Thread.sleep(2000);
		
		
		//List<WebElement> wb1 =driver.findElements(By.xpath("(//a[@class='listFormHeaderLinks'])[1]"));
		//for(WebElement lst:wb1) {
			//System.out.println(lst.getText());
	//Logout
			WebElement ele1 =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wlib.mouseover(driver, ele1);
			driver.findElement(By.linkText("Sign Out")).click();
			
			//close
			driver.close();
		
			
		}
}

