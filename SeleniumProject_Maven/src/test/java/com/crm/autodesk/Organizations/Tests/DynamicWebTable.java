package com.crm.autodesk.Organizations.Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class DynamicWebTable {
	WebDriver driver;
	@Test

	public void handlingDynamicWebtable() throws Throwable {
		JSONFileUtility jsonLib = new JSONFileUtility();

		// fetch the common data from external Resource
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");

		// choose the browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new OperaDriver();
		}
		// load the url
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);

		// login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		// click on organizations
		driver.findElement(By.linkText("Organizations")).click();

		// click on all the checkboxes
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		//for (WebElement wb : list) {
			///wb.click();
	
			for(int i=0;i<list.size();i++) {
				list.get(i=4).click();
			}
			// click on  last check box
			//list.get(list.size()-1).click();
		}
	}

