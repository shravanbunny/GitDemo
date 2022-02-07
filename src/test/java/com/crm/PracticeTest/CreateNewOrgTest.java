package com.crm.PracticeTest;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.vtiger.pomrepositorylib.CreateNewOrganization;
import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationInfoPage;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationPage;
import com.vtiger.comcast.genericUtility.BaseClass;
public class CreateNewOrgTest extends BaseClass{
	
	@Test(retryAnalyzer=com.vtiger.comcast.genericUtility.RetryAnalyzerImp.class)
	
	public void createNewOrgTest() throws Throwable{
		
		wdu.waitForPageToLoad(driver);
		
		Home hp=new Home(driver);
		hp.getOrgLink().click();

		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.getOrgLink().click();
		
		String orgName = exls.getDataFromExcel("Organization", 1, 2) + j.getRanDomNumber();
		
		OrganizationPage op = new OrganizationPage(driver);
			op.createOrganization(orgName);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualorgInfo = oip.getOrgInfo().getText();
		
		Assert.fail();
		
//		String orgName = exls.getDataFromExcel("Organizations", 1, 2);
//		
//		Home hp = new Home(driver);
//		
//		hp.getOrgLink().click();
//		
//		CreateNewOrganization cno = new CreateNewOrganization(driver);
//		cno.getOrgLink().click();
//		
//		OrganizationPage op = new OrganizationPage(driver);
//		op.createOrganization(orgName);
//		
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		String actualOrgName = oip.getOrgInfo().getText();
		
		
		
		
		
		
		
		
		
	
		
	}

}
