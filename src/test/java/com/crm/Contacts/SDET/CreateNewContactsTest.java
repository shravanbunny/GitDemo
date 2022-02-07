package com.crm.Contacts.SDET;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

public class CreateNewContactsTest extends BaseClass{
	@Test(groups= {"SmokeTest"})
	public void createNewContactsTest() throws Throwable {
		
		
			Home hp = new Home(driver);
			hp.getclickOnContactLink().click();
		
			CreateNewContactsImg cnci = new CreateNewContactsImg(driver);
			cnci.getCreateConImg().click();
		
			String lastName = exls.getDataFromExcel("Contacts",4 , 2);
			
			ContactPage cp = new ContactPage(driver);
			cp.createContacts(lastName);
			
			ContactInfoPage cip = new ContactInfoPage(driver);
			
			String actualLastNameInfo = cip.getLastName().getText();
			actualLastNameInfo=actualLastNameInfo.trim();
			
			boolean status = actualLastNameInfo.contains(lastName) ;
			
			Assert.assertTrue(status , "last name not verfied");
			
			
			
			
		}
	}



