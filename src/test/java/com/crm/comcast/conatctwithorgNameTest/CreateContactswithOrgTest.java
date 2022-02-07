package com.crm.comcast.conatctwithorgNameTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.vtiger.pomrepositorylib.ContactPage;
import com.crm.comcast.vtiger.pomrepositorylib.CreateNewContactsImg;
import com.crm.comcast.vtiger.pomrepositorylib.CreateNewOrganization;
import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationInfoPage;
import com.crm.comcast.vtiger.pomrepositorylib.OrganizationPage;
import com.vtiger.comcast.genericUtility.BaseClass;

/**
 * 
 * @author Shravan
 *
 */
	public class CreateContactswithOrgTest extends BaseClass {

		
		@Test(groups={"IntegrationTest"})
		public void createContactwithOrgTest() throws Throwable{
		
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
			
			Assert.assertTrue(status , "orgName Validation Fails");
			
			hp.getclickOnContactLink().click();
			
			CreateNewContactsImg cnci = new CreateNewContactsImg(driver);
			cnci.getCreateConImg().click();
		
			String lastName = exls.getDataFromExcel("Contacts",4 , 2);
			
			ContactPage cp = new ContactPage(driver);
			
			cp.createContacts(lastName, orgName);
			
			
		}


}
