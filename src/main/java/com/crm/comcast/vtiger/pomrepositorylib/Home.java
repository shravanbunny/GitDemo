package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * 
 * @author Shravan
 *
 */
public class Home extends WebDriverUtility{
	
	WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	private WebElement Leadslink;
	
	public WebElement getLeadslink(){
		return Leadslink;
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink ;
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	public WebElement getclickOnContactLink() {
		return contactsLink ;
	}
	
	@FindBy(xpath="//span[@class='userName']/../following-sibling::td[1]/img")
	private WebElement signimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public void getSignOut() {
		mouseOverOnElement(driver , signimg);
		signoutLink.click();
	}
	
}
