package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class LeadInfoPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public LeadInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement leadInfo;
	
	
	public WebElement getLeadInfo() {
		return leadInfo ;
	}
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastNameInfo;
	
	public WebElement getlastNameInfo() {
		return lastNameInfo ;
	}
	
	@FindBy(id="mouseArea_Company")
	private WebElement companyInfo;
	
	public WebElement getcompanyInfo() {
		return companyInfo ;
	}
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryInfo;
	


	public WebElement getIndustryInfo() {
		// TODO Auto-generated method stub
		return industryInfo;
	}

}
