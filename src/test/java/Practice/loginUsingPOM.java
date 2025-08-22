package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.WebSocket;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ninjaCRM.GenericUtility.FileUtility;
import ninjaCRM.GenericUtility.WebDriverUtility;
import ninjaCRM.ObjectRepository.LoginPage;

public class loginUsingPOM {
	
	public static void main(String[] args) throws IOException {
		WebDriverUtility wutil= new WebDriverUtility();
		FileUtility futil=new FileUtility();
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\files\\commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		WebDriver driver = new EdgeDriver();
		wutil.maximizingTheWindow(driver);
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.getUsernameTF().sendKeys(USERNAME);
		lp.getPasswordTF().sendKeys(PASSWORD);
		lp.getSignInBtn().click();
		
		
		
	}

}
