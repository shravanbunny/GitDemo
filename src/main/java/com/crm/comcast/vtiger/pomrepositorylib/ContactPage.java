package com.crm.comcast.vtiger.pomrepositorylib;

import org.openqa.selenium.By;

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

	public class ContactPage extends WebDriverUtility {
		WebDriver driver ;
		public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastname;

	public WebElement getLastName() {
		return lastname;
	}
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement organizationLookUpImg;

	
	public WebElement getOrganizationName() {
		return organizationLookUpImg;
	}
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement supportStartDate;

	public WebElement getsupportStartDate() {
		return supportStartDate;
	}
	@FindBy(id="mobile")
	private WebElement contactInfo;

	public WebElement getcontactInfo() {
		return contactInfo;
	}
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public WebElement getSave() {
		return saveBTN;
	}
	
	public void createContacts(String lastName) {
		lastname.sendKeys(lastName);
		saveBTN.click();
	}
	
	
	public void createContacts(String lastName , String orgName ) {
		lastname.sendKeys(lastName);
		organizationLookUpImg.click();
		switchToWindow(driver,"Accounts&action");
		OrganizationPage op = new OrganizationPage(driver);
		op.getSearchField().sendKeys(orgName);
		op.getSearchOrgName().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); //dynamic xpath
		
	switchToWindow(driver, "Contacts");
	saveBTN.click();
		
	}
	public void createContacts(String lastName,String mobilenum , String date ) {
		lastname.sendKeys(lastName);
		supportStartDate.sendKeys(date);
		contactInfo.sendKeys(mobilenum);
		saveBTN.click();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}