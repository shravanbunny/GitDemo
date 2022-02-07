package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeads {
	
	public CreateNewLeads(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Lead...']")
	private WebElement createLeadsimg;
	
	
	public WebElement getCreateLeadsImg() {
		
		return createLeadsimg;
	}
	
//	public void clickOnCreateLeadsImg() {
//		createLeadsimg.click();
//	}
}
