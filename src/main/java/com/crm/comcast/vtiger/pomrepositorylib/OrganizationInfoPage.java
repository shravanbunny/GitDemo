package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement organizationInfo;
	
	
	public WebElement getOrgInfo() {
		return organizationInfo ;
	}
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industriesInfo;
	
	public WebElement getIndutriesInfo() {
		return industriesInfo ;
	}
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeInfo;
	
	public WebElement getTypeInfo() {
		return typeInfo ;
	}

}
