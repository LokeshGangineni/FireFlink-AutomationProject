package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	
	@FindBy(xpath="//b[.='Opportunities']")
	private WebElement OpportunitiesText;
	
	@FindBy(xpath="//span[.='Create Opportunity']")
	private WebElement OpportunitiesBtn;

	@FindBy(xpath="//select[@class=\"form-control\"]")
	private WebElement SearchByDropdown;


	@FindBy(xpath="//input[@placeholder='Search by Opportunity Id']")
	private WebElement SearchByTextField;

//constructur
	public OrganisationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//getters

	public WebElement getOpportunitiesText() {
		return OpportunitiesText;
	}

	public WebElement getOpportunitiesBtn() {
		return OpportunitiesBtn;
	}

	public WebElement getSearchByDropdown() {
		return SearchByDropdown;
	}

	public WebElement getSearchByTextField() {
		return SearchByTextField;
	}

	

}
