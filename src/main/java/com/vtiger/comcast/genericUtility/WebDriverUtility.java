package com.vtiger.comcast.genericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  its contains WebDriver specific reusable actions 
 * @author Shravan
 *
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before indentifying any sychronized element in DOM [HTML-Docuent]
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWait_TimeOut , TimeUnit.SECONDS);
	}
	
	/**
	 * wait for page to load before indentifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(IConstant.explicitlyWait_TimeOuts, TimeUnit.SECONDS);
	}
	
    /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWait_TimeOuts);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	  /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     * @param pollingTime in the form second
	 * @throws Throwable 
     */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWindowTitle) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			          if(currentWindowTitle.contains(partialWindowTitle)) {
			        	  break;
			          }
		    	}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index ) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param visiblityText
	 */
	public void select(WebElement element , String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param visiblityText
	 */
	
	public void select(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	

	


	

}
