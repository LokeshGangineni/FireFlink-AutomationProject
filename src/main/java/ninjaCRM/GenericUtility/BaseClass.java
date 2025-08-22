package ninjaCRM.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ninjaCRM.ObjectRepository.DashboardPage;
import ninjaCRM.ObjectRepository.LoginPage;

/**
 * This class is a base class wihich does the base functionality
 * @author Gangineni Lokesh
 */
public class BaseClass  {
	
	public FileUtility futil= new FileUtility();
	public WebDriverUtility wutil= new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	
	
	/**
	 * this method is before suite method
	 */
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("***********Db Connected*********");
	}
	
	/**
	 * This method is launching the browser
	 * @throws IOException
	 */
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER= futil.readDataFromPropertiesFile("browser");
		String URL= futil.readDataFromPropertiesFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		
		wutil.maximizingTheWindow(driver);
		driver.get(URL);
		
		System.out.println("************Application is launched *************");
		
		//for listerners
		sdriver=driver;
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME= futil.readDataFromPropertiesFile("username");
		String PASSWORD=futil.readDataFromPropertiesFile("password");
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("**********login successful*********");
		
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		DashboardPage ddp= new DashboardPage(driver);
		ddp.logOut();
		System.out.println("**********logout successful*********");
	}
	

	
	/**
	 * This method id used to close the browser
	 */
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("**********browser is closed*********");
	}
	

	
	/**
	 * this method is after suite method
	 */
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("***********Db disconnected*********");
	}

}
