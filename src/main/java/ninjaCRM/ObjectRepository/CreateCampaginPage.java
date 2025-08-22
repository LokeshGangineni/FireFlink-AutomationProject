package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.GenericUtility.WebDriverUtility;

public class CreateCampaginPage extends WebDriverUtility {
	
	
	@FindBy(xpath="//input[@name='campaignName']")
	private WebElement campaignNameTF;
	@FindBy(xpath="//input[@name='targetSize']")
	private WebElement targetSizeTF;
	@FindBy(xpath="//button[.='Create Campaign']")
	private WebElement createCampaginBtn;
	
	
	public CreateCampaginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCampaignNameText() {
		return campaignNameTF;
	}


	public WebElement getTargetSizeText() {
		return targetSizeTF;
	}
	
	public WebElement getCreateCampaginBtn() {
		return createCampaginBtn;
	}
	
	
	//business logic


	public void creatingCampaign(String campaginName,String targetSize,WebDriver driver)
	{
		campaignNameTF.sendKeys(campaginName);
		targetSizeTF.clear();
		targetSizeTF.sendKeys(targetSize);
		scrollToElementAction(driver, createCampaginBtn);
		createCampaginBtn.click();
		
		
	}
	
	
}
