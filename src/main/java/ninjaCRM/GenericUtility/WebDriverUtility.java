package ninjaCRM.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Gangineni Lokesh
 */
public class WebDriverUtility {
	
	/**
	 * this method is used to maximize the window
	 * @param driver
	 */
	public void maximizingTheWindow(WebDriver driver)
	{
		 driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to minimize  the window
	 * @param driver
	 */
	public void minimizingTheWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method is used to full screen the window
	 * @param driver
	 */
	public void fullscreeningTheWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	//implict wait
	/**
	 * This method is used to add the implicit wait
	 * @param seconds
	 * @param driver
	 */
	public void addingImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used to add the external wait 
	 * @param driver
	 * @param element
	 */
	public void addingExplicitWaitForElemetToClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
//select class
	
	/**
	 * Handling dropdown using select class by visible text
	 * @param webElement
	 * @param visibleText
	 */
	public void handlingDropDownByVisibleText(WebElement webElement,String visibleText)
	{
		Select select = new Select(webElement);
		select.selectByContainsVisibleText(visibleText);
	}
	/**
	 * Handling dropdown using select class by value
	 * @param webElement
	 * @param visibleText
	 */
	public void handlingDropDownByValue(String value,WebElement webElement)
	{
		Select select = new Select(webElement);
		select.selectByValue(value);
	}
	/**
	 * Handling dropdown using select class by index
	 * @param webElement
	 * @param visibleText
	 */
	public void handlingDropDownByIndex(WebElement webElement,int index)
	{
		Select select = new Select(webElement);
		select.selectByIndex(index);
	}
	
//Action class
	/**
	 * This method is used to move the cursor to element
	 * @param driver
	 * @param element
	 */
	
	public void moveToElementAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to drag the element and drop in the other element
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	/**
	 * This method performs click and hold operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void clickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}
	/**
	 * This method performs click and hold  and release operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void clickAndHoldAction(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(element).release().perform();
	}
	/**
	 * click operation
	 * @param element
	 */
	public void click(WebElement element)
	{
		element.click();
	}
	/**
	 * This method performs click  operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void clickAction(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	/**
	 * This method performs    move the cursor to given dimensions operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void moveByOffSetAction(WebDriver driver,int x,int y)
	{
		Actions action = new Actions(driver);
		action.moveByOffset(x, y).perform();
	}
	/**
	 * This method performs  double click on element operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method performs  context / right  click on element operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void contextClickAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * This method is used to scroll the element
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
	/**
	 * This method is used to scroll by amount
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void scrollByAmountAction(WebDriver driver,WebElement element,int x,int y)
	{
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform();
	}
	
	
	
//frames
	
	/**
	 * Switching control to the given name frame
	 * @param driver
	 * @param index
	 */
	public void switchingControlToInnerFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	/**
	 * Switching control to the given index frame
	 * @param driver
	 * @param index
	 */
	public void switchingControlToInnerFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Switching control to the given frame with specific element
	 * @param driver
	 * @param index
	 */
	public void switchingControlToInnerFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * Switching control to the parent page
	 * @param driver
	 * @param index
	 */
	public void switchingControlToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * Switching control to the main page
	 * @param driver
	 * @param index
	 */
	public void switchingControlToMainParent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
//Alerts
	
	/**
	 * This  method is used to handle popup by clicking accept
	 * @param driver
	 */
	public void clickingAcceptOnAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This  method is used to handle popup by clicking dismiss
	 * @param driver
	 */
	public void clickingDismissOnAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This  method is used to get text from popup
	 * @param driver
	 */
	public void gettingTextFromAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This  method is used to send data to popup
	 * @param driver
	 * @param data
	 */
	public void sendingDataToAlert(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}

//handle window
	
	/**
	 * The method is used to switch control to window based on title
	 * @param driver
	 * @param title
	 */

	public void switchingWindow(WebDriver driver,String title)
	{
		 Set<String> setOfIds = driver.getWindowHandles();
		for(String windowId:setOfIds)
		{
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(title))
				break;
		}
	}
	
	/**
	 * this method is used to shift control from parent to child page
	 * @param driver
	 * @param title
	 */
	public void switchingWindowWithInTwoWindows(WebDriver driver)
	{
		
		String mainId= driver.getWindowHandle();
		Set<String> setOfIds = driver.getWindowHandles();
		for(String windowId:setOfIds)
		{
			if(!windowId.equals(mainId))
			{
				driver.switchTo().window(windowId);
			}
		}
	}
	/**
	 * this method is used to capture screenshot return to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String st=".\\screenshots\\"+screenshotName+".png";
		File dest=new File(st);
		FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath(); //for extends report
	}
	

	
}
