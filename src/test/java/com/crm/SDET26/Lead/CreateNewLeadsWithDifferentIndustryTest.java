package com.crm.SDET26.Lead;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.vtiger.pomrepositorylib.CreateNewLeads;
import com.crm.comcast.vtiger.pomrepositorylib.CreateNewLeadsBySelectingDifferentIndustry;
import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.LeadInfoPage;
import com.vtiger.comcast.genericUtility.BaseClass;



public class CreateNewLeadsWithDifferentIndustryTest extends BaseClass {
	
	@Test
	public void createNewLeadsWithDifferentIndustryTest() throws Throwable {
		
		String lastName = exls.getDataFromExcel("Leads", 4, 2) + j.getRanDomNumber();
		String companyName = exls.getDataFromExcel("Leads", 4, 3) + j.getRanDomNumber();
		String industryName = exls.getDataFromExcel("Leads", 4, 4);
		
		System.out.println(industryName);
		
		
		Home hp = new Home(driver);
		hp.getLeadslink().click();
		
		CreateNewLeads cnl = new CreateNewLeads(driver);
		cnl.getCreateLeadsImg().click();
		
		CreateNewLeadsBySelectingDifferentIndustry cnlsb = new CreateNewLeadsBySelectingDifferentIndustry(driver);
		
		cnlsb.inputlastName(lastName);
		cnlsb.inputcompanyName(companyName);
		cnlsb.getIndustryName(industryName);
		
		cnlsb.getsavethecreatedlead().click();
		
		LeadInfoPage lip = new LeadInfoPage(driver);
		
		String actualLeadInfo = lip.getLeadInfo().getText();
		
		boolean status = actualLeadInfo.contains(lastName);
		
		Assert.assertTrue(status);
		
		String actualCompanyName = lip.getcompanyInfo().getText();
		boolean contains = actualCompanyName.contains(companyName);
		
		Assert.assertTrue(contains);
		
		SoftAssert soft = new SoftAssert();
		
		String industrytype = lip.getIndustryInfo().getText();
		
		Assert.assertEquals(industrytype, industryName ,"IndustryName not verified");
		
		soft.assertAll();
	}

}
