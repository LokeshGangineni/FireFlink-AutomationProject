package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//b[.='Contacts']")
	private WebElement contactsText;
	
	@FindBy(xpath="//span[.='Create Contact']")
	private WebElement createContactBtn;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchByDropDown;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchByTF;

	
//constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//getters

	public WebElement getContactsText() {
		return contactsText;
	}


	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}


	public WebElement getSearchByDropDown() {
		return searchByDropDown;
	}


	public WebElement getSearchByTF() {
		return searchByTF;
	}
	
}
