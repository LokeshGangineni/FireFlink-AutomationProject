package ninjaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePurchaseOrderPage {
	
	
	@FindBy(name="dueDate")
	public WebElement dueDateTF;
	@FindBy(name="subject")
	public WebElement subjectTF;
	@FindBy(xpath="//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")
	public WebElement contactPlusBtn;
	@FindBy(id="search-input")
	public WebElement searchTF;
	@FindBy(xpath="//button[.='Select']")
	public WebElement selectBtn;
//	driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 14));
//    driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 15));
//    driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 15));
//    driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 16));
//    driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 16));
//    driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 17));
//    driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 17));
//    driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 18));
//    driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 18));
//    driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 19));
//    driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fileu.ReadDataFromExcel("E2E", 4, 19));
//    driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();    
	@FindBy(name="address")
	public WebElement billingAdressTF;
	@FindBy(name="")
	public WebElement shippingAddressTF;
	@FindBy(name="")
	public WebElement billingPOBoxTF;
	@FindBy(name="")
	public WebElement shippingPOBoxTF;
	@FindBy(name="")
	public WebElement billingCityTF;
	@FindBy(name="")
	public WebElement cityTF;
	@FindBy(name="")
	public WebElement BillingStateTF;
	@FindBy(name="")
	public WebElement stateTF;
	@FindBy(name="")
	public WebElement billingPostalCodeTF;
	@FindBy(name="")
	public WebElement postalCodeTF;
	@FindBy(name="")
	public WebElement billingCountryTF;
	@FindBy(name="")
	public WebElement countryTF;
	@FindBy(name="")
	public WebElement addProductBtn;

}
