package ninjaCRM.ObjectRepository;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.GenericUtility.WebDriverUtility;


public class createProductPage extends WebDriverUtility {
    @FindBy(name = "quantity") 
    private WebElement quantityTF;
    @FindBy(name = "productName") 
    private WebElement productNameTF;
    @FindBy(name = "price") 
    private WebElement priceTF;
    @FindBy(name = "productCategory") 
    private WebElement productCategoryDropDown;
    @FindBy(name = "vendorId") 
    private WebElement vendorIdDD;
    @FindBy(xpath = "//button[.='Add']") 
    private WebElement addProductBtn;
    public WebElement getAddProductBtn() {
        return addProductBtn;
    }
    public createProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
   
    
    public WebElement getQuantityTF() {
		return quantityTF;
	}
	public WebElement getProductNameTF() {
		return productNameTF;
	}
	public WebElement getPriceTF() {
		return priceTF;
	}
	public WebElement getProductCategoryDropDown() {
		return productCategoryDropDown;
	}
	public WebElement getVendorIdDD() {
		return vendorIdDD;
	}
	public void createProduct(String quantity,String productName,String price,String productCategory,String vendor) {
        quantityTF.sendKeys(quantity);
        productNameTF.sendKeys(productName);
        priceTF.clear();
//      priceTF.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        priceTF.sendKeys(price);
        handlingDropDownByVisibleText(productCategoryDropDown, productCategory);
        handlingDropDownByVisibleText(vendorIdDD, vendor);
        addProductBtn.click();
    }
}