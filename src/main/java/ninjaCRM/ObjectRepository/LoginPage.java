package ninjaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//capuring the elements
	@FindBy(id="username")
	private WebElement usernameTF;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy (xpath="//button[.='Sign In']")
	private WebElement signInBtn;

	//constructur that initilize entire page
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//getters
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	
	//business library
	public void loginToApplication(String username,String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}
	
}
