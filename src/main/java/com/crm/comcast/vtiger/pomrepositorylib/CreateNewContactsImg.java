package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * 
 * @author Shravan
 *
 */
public class CreateNewContactsImg extends WebDriverUtility{

	WebDriver driver ;
	public CreateNewContactsImg(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContactsImg;
	
	public WebElement getCreateConImg() {
		return createContactsImg;
	}
}
