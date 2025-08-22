package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v136.emulation.model.SensorMetadata;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ninjaCRM.GenericUtility.FileUtility;
import ninjaCRM.GenericUtility.WebDriverUtility;

public class TestCase_01 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility fu = new FileUtility();
		String address=".\\src\\test\\resources\\files\\commondata.properties";
		FileInputStream fisProperties= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\commondata.properties");
		Properties p= new Properties();
		p.load(fisProperties);
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\TestCases.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		Sheet sh = w.getSheet("TestCases");
//		sh.getRow(1).getCell(2).toString();
		WebDriverUtility wu= new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
		wu.maximizingTheWindow(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wu.addingImplicitWait(driver);
		Actions a= new Actions(driver);
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
//checking login
		WebElement loginCheck = driver.findElement(By.xpath("//b[.='Campaigns']"));
		System.out.println(loginCheck.isDisplayed()?"Step1 login successful":"Step1 login failed");			
		
//step2 and 3	
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//span[.='Create Contact']")).click();
//		String organisationName=sh.getRow(1).getCell(4).toString();
		String organisationName=fu.ReadDataFromExcel("TestCases" , 2, 4);
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organisationName);
//		String titleName=sh.getRow(2).getCell(5).toString();
		String titleName=fu.ReadDataFromExcel("TestCases" , 2, 5);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(titleName);
//		String contactName=sh.getRow(2).getCell(6).toString();
		String contactName=fu.ReadDataFromExcel("TestCases" , 2, 6);
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactName);
//		String mobile=sh.getRow(2).getCell(7).toString();
		String mobile=fu.ReadDataFromExcel("TestCases" , 2, 7);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon='plus']")).click();
		Thread.sleep(2000);
			
//		//
////		WebElement campgianid = driver.findElement(By.xpath("//select[@id='search-criteria']"));
////		Select s= new Select(campgianid);
////		s.selectByIndex(1);
		String mainId = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		for (String string : set) {
			if(!string.equals(mainId))
			{
				driver.switchTo().window(string);
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick=\"selectCampaign('CAM00001', 'Campaigntest')\"]")).click();
		driver.switchTo().window(mainId);
//		a.scrollByAmount(0, 500).perform();
		a.scrollByAmount(0, 500).perform();
		driver.findElement(By.xpath("//button[.='Create Contact']")).click();
//checking after contact creation
		WebElement contactCreationCheck = driver.findElement(By.xpath("//b[.='Contacts']"));
		System.out.println(contactCreationCheck.isDisplayed()?"Step1 contact creation successful":"Step1 contact creatio failed");	
//	
	//Step 4 and 5	
//		products
		driver.findElement(By.xpath("//a[.='Products']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[.='Add Product']")).click();
//		String productName=sh.getRow(2).getCell(9).toString();
		String productName=fu.ReadDataFromExcel( "TestCases" , 2, 9);
		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);
		WebElement category = driver.findElement(By.xpath("//select[@name='productCategory']"));
		
//		a.click(category).perform();
		Select s= new Select(category);
//		String categoryOption = sh.getRow(2).getCell(10).toString();
		String categoryOption = fu.ReadDataFromExcel( "TestCases" , 2, 10);
		s.selectByContainsVisibleText(categoryOption);
//		String quantity = sh.getRow(2).getCell(11).toString();
		String quantity = fu.ReadDataFromExcel( "TestCases" , 2, 11);
		WebElement quantityEle = driver.findElement(By.xpath("//input[@name='quantity']"));
//		a.click(quantityEle).perform();
		wu.clickAction(quantityEle, driver);
		a.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE).perform();
		quantityEle.sendKeys(quantity);
		a.click(quantityEle).perform();
		a.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE).perform();
//		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quantity);
//		String price = sh.getRow(2).getCell(12).toString();
		String price = fu.ReadDataFromExcel( "TestCases" , 2, 12);
		WebElement priceEle = driver.findElement(By.xpath("//input[@name='price']"));
		a.click(priceEle).perform();
		a.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE).perform();
		priceEle.sendKeys(price);
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@name='price']")).sendKeys(price);
		WebElement vector = driver.findElement(By.xpath("//select[@name='vendorId']"));
		Select s1= new Select(vector);
		s1.selectByIndex(1);
		driver.findElement(By.xpath("//button[.='Add']")).click();
		Thread.sleep(3000);
	
//checking
		WebElement productCreationCheck = driver.findElement(By.xpath("//b[.='Products']"));
		System.out.println(productCreationCheck.isDisplayed()?"Step2 product creation successful":"Step1 product creation failed");	
		
//step 6-12		
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Create Order']")).click();
//		String subject = sh.getRow(2).getCell(14).toString();
		String subject = fu.ReadDataFromExcel( "TestCases" , 2, 14);
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
//		String dueDate = sh.getRow(2).getCell(15).toString();
		String dueDate = fu.ReadDataFromExcel( "TestCases" , 2, 11);
		
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(dueDate);
		
		//
//		driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon='plus']")).click();
//		String contact = sh.getRow(2).getCell(16).toString();
		Thread.sleep(2000);
//		Set<String> set1 = driver.getWindowHandles();
//		for (String string : set1) {
//			if(!string.equals(mainId))
//			{
//				driver.switchTo().window(string);
//			}
//		}
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(contact);
			

		driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon='user']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
	}

}
