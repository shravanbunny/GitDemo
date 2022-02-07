package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewLeadsBySelectingDifferentIndustry {
	
	WebDriver driver;
	public CreateNewLeadsBySelectingDifferentIndustry(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement inputLastName;
	
	public WebElement getlastName() {
		return inputLastName;
	}
	
	public void inputlastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}
	
	@FindBy(name="company")
	private WebElement inputCompanyName;
	
	public WebElement getCompanyName() {
		return inputCompanyName;
	}
	
	public void inputcompanyName(String companyName) {
		inputCompanyName.sendKeys(companyName);
	}
	
	@FindBy(name="leadsource")
	private WebElement leadSource;
	
	public WebElement getleadSource() {
		return leadSource ;
	}
	
	public void getLeadSource(String leadsourceName) {
		Select s = new Select(leadSource);
		s.selectByVisibleText(leadsourceName);
	}
	
	@FindBy(name="industry")
	private WebElement industry;
	
	public WebElement getIndustryName(String industryName) {
		Select s = new Select(industry);
		s.selectByVisibleText(industryName);
		 return industry;
	}
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement save ;
	
	public WebElement getsavethecreatedlead() {
		return save;
		
	}
}
