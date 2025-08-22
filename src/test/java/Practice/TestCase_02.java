package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import ninjaCRM.GenericUtility.FileUtility;
import ninjaCRM.GenericUtility.WebDriverUtility;

public class TestCase_02 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverUtility wu=new WebDriverUtility();
		FileInputStream fisProperties= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\commondata.properties");
		Properties p= new Properties();
		p.load(fisProperties);
//file utility
//		FileUtility fu = new FileUtility();
		String username = p.getProperty("username");
		String password = p.getProperty("password");
//		FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\TestCases.xlsx");
//		Workbook w = WorkbookFactory.create(fis);
//		Sheet sh = w.getSheet("TestCases");
		
		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
		
		wu.maximizingTheWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a= new Actions(driver);
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		
		//checking login
				WebElement loginCheck = driver.findElement(By.xpath("//b[.='Campaigns']"));
				System.out.println(loginCheck.isDisplayed()?"Step1 login successful":"Step1 login failed");	
		//clicking purchase order
				driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[.='Create Order']")).click();
				
				
	}

}
