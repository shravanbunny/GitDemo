package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility{
	
	WebDriver driver ;
	
	public CreateNewOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Organization...']")
	private WebElement clickOnOrgLink;
	
	public WebElement getOrgLink() {
		return clickOnOrgLink;
	}
	
	
	
	

}
