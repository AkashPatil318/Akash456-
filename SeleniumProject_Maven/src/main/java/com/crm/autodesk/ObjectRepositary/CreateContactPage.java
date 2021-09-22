package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class CreateContactPage {
	
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveImg;
	
	@FindBy(name="lastname")
	private WebElement ConNameEdt;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
			private WebElement OrgNamLnk;
	
	@FindBy(xpath="//a[text()='vtigerABC']")
	private WebElement exstdEdt;
	
	@FindBy(xpath="//input[@name='imagename']")
	private WebElement chooseImg;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
			private WebElement RepLnk;
	@FindBy(linkText="Linda Williams")
	private WebElement ExstEdt;
	
	@FindBy(xpath="//img[@alt='Import Contacts']")
	private WebElement ImpImg;
	
	@FindBy(xpath="//input[@name='import_file']")
	private WebElement ImpFile;
	
	@FindBy(xpath="//input[@class='crmButton big edit']")
	private WebElement NextBtn;
	

	public WebElement getNextBtn()
	{
		return NextBtn;
	}


	public WebElement getImpFile() 
	{
		return ImpFile;
	}


	public WebElement getImpImg() 
	{
		return ImpImg;
	}

	
	public WebElement getExstEdt() 
	{
		return ExstEdt;
	}
	public void ClickonExsRep()
    {
    	ExstEdt.click();
    }
	public WebElement getRepLnk() {
		return RepLnk;
	}
	public WebElement getChooseImg() {
		return chooseImg;
	}
	public WebElement getExstdEdt() {
		return exstdEdt;
	}
	public WebElement getOrgNamLnk() {
		return OrgNamLnk;
	}
	public WebElement getConNameEdt() {
		return ConNameEdt;
	}
	public WebElement getSaveImg()
	{
		return SaveImg;
	}
	public void clickonSave()
	{
		SaveImg.click();
	}
    public void createContact(String ConName)
    {
    	ConNameEdt.sendKeys(ConName);
    }
    
    public void ClickOnOrgName()
    {
    	OrgNamLnk.click();
    }
    public void ClickonExistingName()
    {
    	exstdEdt.click();
    
    }
    public void ClickonChooseFile()
    {
    	chooseImg.sendKeys("F:\\GROOMING.jpeg");
    }
    public void ClickOnRepName()
    {
    	RepLnk.click();
    }
    public void ClickonImport()
    {
    	ImpImg.click();
    }
    
    public void  SelectImpFile()
    {
    	ImpFile.sendKeys("F:\\Organizations.csv");
    }
    public void ClickonNext()
    {
    	NextBtn.click();
    }
    
    WebDriverUtility ww = new WebDriverUtility();
    @FindBy(xpath="(//select[@class='txtBox'])[1]")
	private WebElement selectDropdown;


	public WebElement getSelectDropdown() 
	{
		return selectDropdown;
	}
    
	public void selectDropdown(String value)
	{
		selectDropdown.click();
		ww.select(selectDropdown, value);
	}
	
	public void selectDropdown(int value)
	{
		ww.select(selectDropdown, value);
	}
	
	
	@FindBy(css="[type='submit']")
	private WebElement clickOnimport;
	
	public WebElement getClickOnimport() 
	{
		return clickOnimport;	
	}
	
	public void clickOnimport()
	{
		clickOnimport.click();
	}
			
			
			
}


	
