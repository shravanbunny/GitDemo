package com.crm.Contacts.SDET;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.vtiger.pomrepositorylib.ContactInfoPage;
import com.crm.comcast.vtiger.pomrepositorylib.ContactPage;
import com.crm.comcast.vtiger.pomrepositorylib.CreateNewContactsImg;
import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.LoginPage;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

/**
 * 
 * @author Shravan
 *
 */
public class CreateContact_Support_DateTest extends BaseClass {
	@Test(groups={"SmokeTest" , "RegressionTest"})
	public void createContactwithsuppoertDateTest() throws Throwable {
		
			
			Home hp=new Home(driver);
			hp.getclickOnContactLink().click();
		
			CreateNewContactsImg cnci = new CreateNewContactsImg(driver);
			cnci.getCreateConImg().click();
		
			String lastName = exls.getDataFromExcel("Contacts",4 , 2);
			
			String mobilenum = exls.getDataFromExcel("Contacts", 4, 3);
			
			ContactPage cp = new ContactPage(driver);
			cp.createContacts(lastName, mobilenum, j.getSystemDate());
			
			
			ContactInfoPage cip = new ContactInfoPage(driver);
			
			String actualLastNameInfo = cip.getLastName().getText();
			
			System.out.println(actualLastNameInfo);
			
			boolean contains = actualLastNameInfo.contains(lastName);
			
			Assert.assertTrue(contains, "Last Name not Verified");
			
	}

}
