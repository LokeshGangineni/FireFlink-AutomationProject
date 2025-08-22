package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class tt {
	public static void main(String[] args) throws IOException, InterruptedException {


		FileInputStream fis = new FileInputStream("C:\\EclipseFolder\\Fireflink.ninzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");

		Properties prop = new Properties();

		prop.load(fis);

		String BROWSER = prop.getProperty("browser");

		String URL = prop.getProperty("url");

		String USERNAME = prop.getProperty("username");

		String PASSWORD = prop.getProperty("password");

		

		WebDriver driver = null;

		if(BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		}else if(BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();

		}else if (BROWSER.equals("Edge")) {

			driver = new EdgeDriver();

		}else {

			driver = new ChromeDriver();

		}

	

//		1)Login to App with valid Credentials

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(USERNAME);

		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);

		driver.findElement(By.xpath("//button[.='Sign In']")).click();

		

		FileInputStream exceldata = new FileInputStream("C:\\EclipseFolder\\Fireflink.ninzaCRM.AutomationFramework\\src\\test\\resources\\Copy_of_TestData.xlsx");

		Workbook wb = WorkbookFactory.create(exceldata);

		Sheet sheet = wb.getSheet("Sheet1");

		Row col = sheet.getRow(4);

		

//		2)Click on Purchase Order Button

		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();

		

//		3)Click on Create Order Button

		driver.findElement(By.xpath("//span[.='Create Order']")).click();

		

//		4)Create Purchase order with Product and contact

		driver.findElement(By.name("dueDate")).sendKeys(col.getCell(12).toString());

		driver.findElement(By.name("subject")).sendKeys(col.getCell(13).toString());

		driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();

		String currId = driver.getWindowHandle();

		Set<String> allIds1 = driver.getWindowHandles();

		for(String id:allIds1) {

			if(!currId.equals(id)) {

				driver.switchTo().window(id);

			}

		}

		driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");

		driver.findElement(By.xpath("//button[.='Select']")).click();

		driver.switchTo().window(currId);

		driver.findElement(By.name("address")).sendKeys(col.getCell(14).toString());

		driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(col.getCell(14).toString());

		driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(col.getCell(15).toString());

		driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(col.getCell(15).toString());

		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(col.getCell(16).toString());

		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(col.getCell(16).toString());

		driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(col.getCell(17).toString());

		driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(col.getCell(17).toString());

		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(col.getCell(18).toString());

		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(col.getCell(18).toString());

		driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(col.getCell(19).toString());

		driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(col.getCell(19).toString());		

		driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();	

		Set<String> allIds2 = driver.getWindowHandles();

		for(String id:allIds2) {

			if(!currId.equals(id)) {

				driver.switchTo().window(id);

			}

		}

		Select prodSel = new Select(driver.findElement(By.id("search-criteria")));

		

		prodSel.selectByValue("productName");

		driver.findElement(By.id("search-input")).sendKeys("vivo");

		driver.findElement(By.xpath("//button[.='Select']")).click();

		driver.switchTo().window(currId);

		driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();

		try {

			driver.findElement(By.xpath("//button[@aria-label='close']")).click();

			}catch(Exception e) {Thread.sleep(6000);}

		

		

		Row col2 = sheet.getRow(7);

//		5)Click on Products and search that product by it's name

		driver.findElement(By.xpath("//a[.='Products']")).click();

		Select prodIdEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

		prodIdEle.selectByValue("productName");

		driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(col2.getCell(5).toString());

		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();

		WebElement priceEle = driver.findElement(By.name("price"));

		priceEle.clear();

		priceEle.sendKeys("78000");

		driver.findElement(By.xpath("//button[.='Update']")).click();

		try {

		driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();

		}catch(Exception e) {Thread.sleep(5000);}

		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();

		Select orderEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));

		orderEle.selectByValue("subject");

		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(col.getCell(13).toString());

		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();

		driver.findElement(By.name("dueDate")).sendKeys(col.getCell(12).toString());

		driver.findElement(By.xpath("//button[.='Update Purchase Order']")).click();

		try {

			driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();

			}catch(Exception e) {Thread.sleep(5000);}

		driver.findElement(By.className("user-icon")).click();

		driver.findElement(By.xpath("//div[.='Logout ']")).click();

	}

}
