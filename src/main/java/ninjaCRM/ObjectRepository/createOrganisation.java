package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrganisation {
	
	@FindBy(xpath="//input[@name='opportunityName']")
	private WebElement opportunityNameText;
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amountText;
	@FindBy(xpath="//input[@name='businessType']")
	private WebElement bussinessTypeText;
	@FindBy(xpath="//input[@name='nextStep']")
	private WebElement nextStepText;
	@FindBy(xpath="//input[@name='salesStage']")
	private WebElement salesStageText;
	@FindBy(xpath="//*[local-name()='svg'and @data-icon='plus']")
	private WebElement leadAddSymbolBtn;
	public createOrganisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getOpportunityNameText() {
		return opportunityNameText;
	}
	public WebElement getAmountText() {
		return amountText;
	}
	public WebElement getBussinessTypeText() {
		return bussinessTypeText;
	}
	public WebElement getNextStepText() {
		return nextStepText;
	}
	public WebElement getSalesStageText() {
		return salesStageText;
	}
	public WebElement getLeadAddSymbolBtn() {
		return leadAddSymbolBtn;
	}
	

}
