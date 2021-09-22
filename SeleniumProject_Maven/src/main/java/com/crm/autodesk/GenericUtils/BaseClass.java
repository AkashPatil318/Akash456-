package com.crm.autodesk.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver staticdriver;
	public DataBaseUtility dbLib = new DataBaseUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public PropertyFileUtility tLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void ConnectDB() throws Throwable
	{
		//dbLib.connectTODatabase();
		System.out.println("=========MakeDBConnection=========");
	}
	//@Parameters("Browser")

	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void launchBrowser( ) throws Throwable
	{
		System.out.println("==========LaunchBrowser=========");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL= jsonLib.readDataFromJSON("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		wlib.WaitForPageLoad(driver);
		wlib.maximizeWindow(driver);
		driver.get(URL);
		staticdriver=driver;
	}
	
@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
public void loginToApp() throws Throwable
{
	System.out.println("==========LoginToApp==========");
	String USERNAME = jsonLib.readDataFromJSON("username");
	String PASSWORD = jsonLib.readDataFromJSON("password");
	
	LoginPage lp = new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
}

	

@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
public void logoutofApp()
{
	System.out.println("==========LogoutToApp==========");
	HomePage Hp =new HomePage(driver);
	Hp.clickOnSignOut(driver);
	
}

@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
public void closeBrowser()
{
	System.out.println("==========CloseBrowser==========");
	driver.close();
}
@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
public void closeDB() throws Throwable
{
	//dbLib.closeDb();
	System.out.println("==========CloseDB==========");
}
public String getScreenShot(String name) throws IOException 
{
	File srcfile=  ((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
	String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+jLib.getRandomNum()+".png";
	File finaldest = new File(destfile);
	FileUtils.copyFile(srcfile,finaldest);
	return destfile;
}
	
		
}

