package ninjaCRM.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.GenericUtility.WebDriverUtility;


public class CreateContactPage extends WebDriverUtility{
    @FindBy(name = "contactName") 
    private WebElement contactNameTF;
    @FindBy(name = "organizationName") 
    private WebElement organizationNameTF;
    @FindBy(name = "mobile") 
    private WebElement mobileTF;
    @FindBy(name = "title") 
    private WebElement titleTF;
    @FindBy(xpath ="//button[.='Create Contact']")
    private WebElement createContactBtn;
    @FindBy(xpath ="//*[local-name()='svg' and @data-icon=\"plus\"]") 
    private WebElement addCampaignBtn;
    
    @FindBy(id = "search-input") 
    private WebElement searchCampaignInput;
    @FindBy(xpath ="//button[.='Select']") 
    private WebElement selectCampaignBtn;
    
    public WebElement getSearchCampaignInput() {
        return searchCampaignInput;
    }
    public WebElement getSelectCampaignBtn() {
        return selectCampaignBtn;
    }
    public CreateContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public WebElement getContactNameTF() {
        return contactNameTF;
    }
    public WebElement getOrganizationNameTF() {
        return organizationNameTF;
    }
    public WebElement getMobileTF() {
        return mobileTF;
    }
    public WebElement getTitleTF() {
        return titleTF;
    }
    public WebElement getCreateContactBtn() {
        return createContactBtn;
    }
    public WebElement getAddCampaignBtn() {
        return addCampaignBtn;
    }
    
    //Business Library
    public void createContact(WebDriver driver,String organisation,String title,String contactName,String mobile,String searchText)  {
//    	String mainId=driver.getWindowHandle();
    	organizationNameTF.sendKeys(organisation);
    	titleTF.sendKeys(title);
    	contactNameTF.sendKeys(contactName);
    	mobileTF.sendKeys(mobile);
    	addCampaignBtn.click();
    	switchingWindowWithInTwoWindows(driver);
    	searchCampaignInput.sendKeys(searchText);
    	selectCampaignBtn.click();
//    	driver.switchTo().window(mainId);
    	switchingWindow(driver, "Ninza CRM");
    	scrollToElementAction(driver, createContactBtn);
    	createContactBtn.click();
    	
    	
        

    }
}
