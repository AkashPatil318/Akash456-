package com.crm.autodesk.GenericUtils;

import static org.testng.Assert.expectThrows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**
	 * 
	 * @param driver
	 */

	public void WaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	public void select(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	public void select(WebElement element,int index) {
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	public void mouseover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightclick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String FetchMsgAlert(WebDriver driver) {
		String Value=driver.switchTo().alert().getText();
		return Value;
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String frameid) {
		driver.switchTo().frame(frameid);
		
	}
	public void switchToFrame(WebDriver driver,WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}
	public void switchToWindow(WebDriver driver,String Partialwindowtitle) {
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while(it.hasNext()) {
			String winid = it.next();
			String acttitle = driver.switchTo().window(winid).getTitle();
		if(acttitle.contains(Partialwindowtitle)) {
			//driver.switchTo().window(acttitle);
			break;
		}
		
	}
	}
}
