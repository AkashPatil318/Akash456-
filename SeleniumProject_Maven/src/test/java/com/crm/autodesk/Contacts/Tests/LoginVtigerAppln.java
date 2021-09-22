package com.crm.autodesk.Contacts.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginVtigerAppln {
	public static void main(String[]args)
	{
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://localhost:8888/");
	

	
driver.findElement(By.name("user_name")).sendKeys("admin");

driver.findElement(By.name("user_password")).sendKeys("root");

driver.findElement(By.id("submitButto")).click();

}
}