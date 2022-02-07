package com.vtiger.comcast.genericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author Shravan
 *
 */
public class LisImpClass implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		JavaUtility j= new JavaUtility();
		
		String testName = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		String date = j.getDateAndTime();		
		File destFile = new File("./screenShot/" + testName + "_" + date + ".png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	
	

}
