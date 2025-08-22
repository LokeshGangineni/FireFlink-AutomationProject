package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	
	@FindBy(xpath="//b[.='Products']")
	public WebElement productsText;
	
	@FindBy(xpath="//span[.='Add Product']")
	private WebElement addProductsBtn;
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement SearchByDropdown;
	@FindBy(xpath="//input[@placeholder='Search by product Id']")
	private WebElement searchbyText;
	
	
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getProductsText() {
		return productsText;
	}



	public WebElement getAddProductsBtn() {
		return addProductsBtn;
	}



	public WebElement getSearchByDropdown() {
		return SearchByDropdown;
	}



	public WebElement getSearchbyText() {
		return searchbyText;
	}
	
	
	
	
	
	

}
