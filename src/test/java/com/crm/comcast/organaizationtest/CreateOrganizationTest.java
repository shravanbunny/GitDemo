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
import org.testng.Assert;
import org.testng.annotations.Test;

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

public class CreateOrganizationTest extends BaseClass {
			@Test(groups={"FunctionalTest"})
		public void createOrganizationTest() throws Throwable {
				
		
		
		Home hp=new Home(driver);
		hp.getOrgLink().click();

		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.getOrgLink().click();
		
		String orgName = exls.getDataFromExcel("Organization", 1, 2) + j.getRanDomNumber();
		
		OrganizationPage op = new OrganizationPage(driver);
			op.createOrganization(orgName);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualorgInfo = oip.getOrgInfo().getText();
		
		boolean status = actualorgInfo.contains(orgName);
		
		Assert.assertTrue(status ,"Organization Verification Failed ");
}

}
