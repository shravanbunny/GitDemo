package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	WebDriver driver ;
	public ContactInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement lastnameInfo;

	public WebElement getLastName() {
		return lastnameInfo;
	}

}
