package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ninjaCRM.GenericUtility.FileUtility;
import ninjaCRM.GenericUtility.WebDriverUtility;
import ninjaCRM.ObjectRepository.CreateCampaginPage;
import ninjaCRM.ObjectRepository.LoginPage;

public class CreateCampaginTest {
	@Test
	public  void createCampaginTest() throws IOException {
		
		 FileUtility fileu= new FileUtility();
	        WebDriverUtility webUty= new WebDriverUtility();
	        String url="C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\commondata.properties";
	        String BROWSER=fileu.readDataFromPropertiesFile("browser");
	        String URL = fileu.readDataFromPropertiesFile("url");
	        String USERNAME= fileu.readDataFromPropertiesFile("username");
	        String PASSWORD= fileu.readDataFromPropertiesFile("password");
	        WebDriver driver = null;
	        if(BROWSER.equals("chrome")) {
	            driver = new ChromeDriver();
	        }else if(BROWSER.equals("firefox")) {
	            driver = new FirefoxDriver();
	        }else if (BROWSER.equals("edge")) {
	            driver = new EdgeDriver();
	        }else {
	            driver = new ChromeDriver();
	        }
	        webUty.maximizingTheWindow(driver);
	        webUty.addingImplicitWait(driver);
	        driver.get(URL);
	        
	        //POM Class
	        
	//login 
	        LoginPage lp = new LoginPage(driver);
	        lp.loginToApplication(USERNAME, PASSWORD);
	
	//createCampagin
	 String TARGETSIZE="5";
	 
	   driver.findElement(By.xpath("//a[.='Campaigns']")).click();
	   driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
	   CreateCampaginPage ccp= new CreateCampaginPage(driver);
	   ccp.creatingCampaign(USERNAME,TARGETSIZE  , driver);
	}

}
