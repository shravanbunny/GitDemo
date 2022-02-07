package com.crm.comcast.organaizationtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.vtiger.pomrepositorylib.CreateNewOrganization;
import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.LoginPage;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationInfoPage;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationPage;
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
@Listeners(com.vtiger.comcast.genericUtility.LisImpClass.class)
public class CreateOrganization_With_Industries_And_Type_Test extends BaseClass{
	
		@Test    //(groups={"SmokeTest"})
	public void createOrgWithIndusAndTypeTest() throws Throwable {
			
			
		String orgName = exls.getDataFromExcel("Organization", 4, 2) + j.getRanDomNumber();
		
		String industries = exls.getDataFromExcel("Organization", 4, 3);
		
		String type = exls.getDataFromExcel("Organization", 4, 4);
		
		Home hp = new Home(driver);
		hp.getOrgLink().click();
		
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		
		cno.getOrgLink().click();;
		
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrganization(orgName, industries, type);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualorgInfo = oip.getOrgInfo().getText();
		
		boolean status = actualorgInfo.contains(orgName);
	
		Assert.assertTrue(status , "Org Name not verified");
		
		SoftAssert soft = new SoftAssert();
		
		String actualIndustriesInfo = oip.getIndutriesInfo().getText();
		
		soft.assertEquals(actualIndustriesInfo,industries ,"Industries Validation Fails");
		
		
		String actualTypeInfo = oip.getTypeInfo().getText();
		
		soft.assertEquals(actualTypeInfo,type , "type not validated");
		
		soft.assertAll();
		
		
		
	}

}
