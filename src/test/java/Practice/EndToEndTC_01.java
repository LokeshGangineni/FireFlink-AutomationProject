package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import ninjaCRM.GenericUtility.FileUtility;
import ninjaCRM.GenericUtility.WebDriverUtility;
import ninjaCRM.ObjectRepository.CreateCampaginPage;
import ninjaCRM.ObjectRepository.CreateContactPage;
import ninjaCRM.ObjectRepository.LoginPage;
import ninjaCRM.ObjectRepository.createProductPage;
//import ninzaCRM.genericUtilities.FileUtility;
//import ninzaCRM.genericUtilities.WebDriverUtility;
//import ninzaCRM.objectRepository.LoginPage;

public class EndToEndTC_01 {
    public static void main(String[] args) throws Exception {
    	
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
        
        LoginPage lp = new LoginPage(driver);
//login 
//        lp.getUsernameTF().sendKeys(fileu.readDataFromPropertiesFile("username"));
//        lp.getPasswordTF().sendKeys(fileu.readDataFromPropertiesFile("password"));
//        lp.getSignInBtn().click();
//login
        lp.loginToApplication(USERNAME, PASSWORD);
        
//        driver.findElement(By.id("username")).sendKeys(fileu.readDataFromPropertyFile("un"));
//        driver.findElement(By.id("inputPassword")).sendKeys(fileu.readDataFromPropertyFile("pass"));
//        driver.findElement(By.xpath("//button[.='Sign In']")).click();
        
//Create Contact
//        driver.findElement(By.xpath("//a[.='Contacts']")).click();
//        driver.findElement(By.xpath("//span[.='Create Contact']")).click();
//        String CONTACTNAME=fileu.ReadDataFromExcel("E2E", 4, 2);
//        String ORGANISATIONNAME=fileu.ReadDataFromExcel("E2E", 4, 3);
//        String MOBILE=fileu.ReadDataFromExcel("E2E", 4, 4);
//        String TITLE=fileu.ReadDataFromExcel("E2E", 4, 5);
//        String SEARCHTEXT=fileu.ReadDataFromExcel("E2E", 4, 6);
//        CreateContactPage cContactPage= new CreateContactPage(driver);
//        cContactPage.createContact(driver, ORGANISATIONNAME, TITLE, CONTACTNAME, MOBILE, SEARCHTEXT);
// create contact 
//        driver.findElement(By.name("contactName")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 2));
//        driver.findElement(By.name("organizationName")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 3));
//        driver.findElement(By.name("mobile")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 4));
//        driver.findElement(By.name("title")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 5));
//        driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon=\"plus\"]")).click();
        String currId = driver.getWindowHandle();
//        webUty.switchingWindowWithInTwoWindows(driver);
////        driver.findElement(By.id("search-input")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 6));
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[.='Select']")).click();
//        driver.switchTo().window(currId);
//        driver.findElement(By.xpath("//button[.='Create Contact']")).click();
        
       
//    // create campagin
//        String TARGETSIZE="5";
//        driver.findElement(By.xpath("//a[.='Campaigns']")).click();
//        driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
//        CreateCampaginPage ccp= new CreateCampaginPage(driver);
//        ccp.creatingCampaign(USERNAME,TARGETSIZE  , driver);
//        

//        Thread.sleep(3000);
        
        
        
//        Add Product
        driver.findElement(By.xpath("//a[.='Products']")).click();
        driver.findElement(By.xpath("//span[.='Add Product']")).click();
        createProductPage cProductPage= new createProductPage(driver);
        
        String QUANTITY=fileu.ReadDataFromExcel("E2E", 4, 7);
        String productName=fileu.ReadDataFromExcel("E2E", 4, 8);
        String PRICE=fileu.ReadDataFromExcel("E2E", 4, 9);
        String PRODUCTCATEGORY=fileu.ReadDataFromExcel("E2E", 4, 10);
        String VENDORCATEGORY=fileu.ReadDataFromExcel("E2E", 4, 11);
        cProductPage.createProduct(QUANTITY, productName, PRICE, PRODUCTCATEGORY, VENDORCATEGORY);
        
//       
//        driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
//        
//        if(productVerify.isDisplayed()) {
//
//            System.out.println("status---> PASS");
//
//            productVerify.click();
//
//        }
//
//        driver.findElement(By.name("quantity")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 7));
//
//        driver.findElement(By.name("productName")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 8));//col.getCell(8).toString()
//
//        WebElement pricePerUnEle = driver.findElement(By.name("price"));
//
//        pricePerUnEle.clear();
//
//        pricePerUnEle.sendKeys(fileu.ReadDataFromExcel("E2E", 4, 9));
//
//        WebElement prodCategEle = driver.findElement(By.name("productCategory"));
//
//        Select catgSel = new Select(prodCategEle);
//
//        catgSel.selectByValue(fileu.ReadDataFromExcel("E2E", 4, 10));
//
//        Select venderSel = new Select(driver.findElement(By.name("vendorId")));
//
//        venderSel.selectByVisibleText(fileu.ReadDataFromExcel("E2E", 4, 11));
//
//        driver.findElement(By.xpath("//button[.='Add']")).click();

//        try {
//            driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//        }catch(Exception e) {Thread.sleep(5000);}

        
        
        
        
//        //Purchase Order
//        driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
//        driver.findElement(By.xpath("//span[.='Create Order']")).click();
//        driver.findElement(By.name("dueDate")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 12));
//        driver.findElement(By.name("subject")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 13));
//        driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();
//
//        webUty.switchingWindowWithInTwoWindows(driver);
//
//        driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");
//
//        driver.findElement(By.xpath("//button[.='Select']")).click();
//
//        driver.switchTo().window(currId);
//
//        driver.findElement(By.name("address")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 14));
//        driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 14));
//        driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 15));
//        driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 15));
//        driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 16));
//        driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 16));
//        driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 17));
//        driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 17));
//        driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 18));
//        driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 18));
//        driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 19));
//        driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 19));
//        driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();    
//        webUty.switchingWindowWithInTwoWindows(driver);
//        WebElement searchEle = driver.findElement(By.id("search-criteria"));
//        webUty.handlingDropDownByVisibleText( searchEle,"productName");
//        driver.findElement(By.id("search-input")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 8));
//        driver.findElement(By.xpath("//button[.='Select']")).click();
//        driver.switchTo().window(currId);
//        driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
//        try {
//            driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//            }catch(Exception e) {Thread.sleep(6000);}
//        driver.findElement(By.className("user-icon")).click();
//        driver.findElement(By.xpath("//div[.='Logout ']")).click();
    }
}
