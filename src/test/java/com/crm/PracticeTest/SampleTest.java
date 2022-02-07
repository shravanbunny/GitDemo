package com.crm.PracticeTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.LisImpClass;

/**
 * 
 * @author Shravan
 *
 */



@Listeners(com.vtiger.comcast.genericUtility.LisImpClass.class)
public class SampleTest extends BaseClass {
	
	@Test
	public void check() {
		
		Home hp = new Home(driver);
		
		
		
		System.out.println("================Test Start============");
		
		Assert.fail();
		
		System.out.println("================Test End============");
		
		
		
}

}
