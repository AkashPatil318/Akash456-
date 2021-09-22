package com.crm.autodesk.Contacts.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAmazonPhoneVal {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int price = 15000;
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones Below "+price);
	
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		Thread.sleep(3000);
		WebElement actual=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		 
		String Price = actual.getText();
		System.out.println(Price);
		
		String a = Price.replace(",", "");
		int b = Integer.parseInt(a);
		if(b<price)
		{
			System.out.println("validation pass");
		}
		else
		{
			System.out.println("validation fail");
		}
		
		driver.close();
	}
}
