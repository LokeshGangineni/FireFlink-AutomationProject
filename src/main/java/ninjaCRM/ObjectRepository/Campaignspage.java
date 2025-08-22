package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.GenericUtility.WebDriverUtility;


public class Campaignspage extends WebDriverUtility
{
    @FindBy(name = "campaignName")
    private WebElement campaignNameTF;
    
    
    @FindBy(name = "campaignStatus")
    private WebElement campaignStatusTF;
    
    
    @FindBy(name = "targetSize")
    private WebElement targetSizeTF;
    
    
    @FindBy(name = "expectedCloseDate")
    private WebElement expectedCloseDate;
    
    
    @FindBy(name = "targetAudience")
    private WebElement targetAudienceTF;
    
    @FindBy(name = "description")
    private WebElement descriptionTF;
    
    @FindBy(xpath = "//button[text()='Create Campaign']")
    private WebElement createCampaignButton;
    
    public Campaignspage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCampaignNameTF() {
        return campaignNameTF;
    }

    public WebElement getCampaignStatusTF() {
        return campaignStatusTF;
    }

    public WebElement getTargetSizeTF() {
        return targetSizeTF;
    }

    public WebElement getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public WebElement getTargetAudienceTF() {
        return targetAudienceTF;
    }

    public WebElement getDescriptionTF() {
        return descriptionTF;
    }

    public WebElement getCreateCampaignButton() {
        return createCampaignButton;
    }
    
    public void sendDataIntoMandatoryFields(String campaignName,int targetSize)
    {
        getCampaignNameTF().sendKeys(campaignName);
        getTargetSizeTF().sendKeys(targetSize+"");
        click(createCampaignButton);
    }
}