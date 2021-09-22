package com.crm.autodesk.Contacts.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLenskartAutoSugesstion {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[type='text']")).sendKeys("ray");
		Thread.sleep(2000);
		List<WebElement> lst = driver.findElements(By.id("idf_banner-0"));
		for(WebElement wb:lst) 
		{
		System.out.println(wb.getText());

	    }
     driver.close();
}
}
