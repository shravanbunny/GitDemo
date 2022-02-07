package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {
	
	WebDriver driver ;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgnizationName;
	
	public WebElement getOrgName() {
		return orgnizationName;
	}
	
	@FindBy(name="industry")
	private WebElement getIndustryName;
	
	public WebElement getindustryName() {
		return getIndustryName ;
	}
	
	@FindBy(name="accounttype")
	private WebElement getTypeDropdown ;
	
	public WebElement gettypeDropdown() {
		return getTypeDropdown ;
	}
	@FindBy(name="search_text")
	private WebElement searchField ;
	
	public WebElement getSearchField() {
		return searchField ;
	}
	
	@FindBy(css="input[name='search']")
	private WebElement searchOrgName ;
	
	public WebElement getSearchOrgName() {
		return searchOrgName ;
	}
	
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public WebElement getSave() {
		return saveBTN;
	}
	
	public void createOrganization(String orgName) {
		orgnizationName.sendKeys(orgName);
		saveBTN.click();
	}
	
	public void createOrganization(String orgName , String industries) {
		orgnizationName.sendKeys(orgName);
		select(getIndustryName , industries);
		saveBTN.click();
	}
	
	public void createOrganization(String orgName , String industries ,String type) {
		orgnizationName.sendKeys(orgName);
		select(getIndustryName , industries);
		select(getTypeDropdown , type);
		saveBTN.click();
		waitForElementToBeClickable(driver, saveBTN);
		
		
		}
	
	
	
	

}
