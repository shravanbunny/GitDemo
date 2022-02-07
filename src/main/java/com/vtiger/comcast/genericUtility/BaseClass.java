package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.vtiger.pomrepositorylib.Home;
import com.crm.comcast.vtiger.pomrepositorylib.LoginPage;

/**
 * 
 * @author Shravan
 *
 */

public class BaseClass {
	
	public static WebDriver sDriver;
	public WebDriver driver = null;
	
	public ExcelUtility exls = new ExcelUtility();

	public FileUtility data = new FileUtility();
	
	public WebDriverUtility wdu = new WebDriverUtility();
	
	public JavaUtility j = new JavaUtility();
	
	  
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void DbConnection() {
		System.out.println(" Implementing DataBase Connection..........");
		
	}
	
 //  @Parameters("browser")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void launchBrowser() throws Throwable {
		
		String browser=data.getPropertyFromKeyValue("browser");
		
		if(browser.equals("chrome")) {
			
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
		
			driver=new FirefoxDriver();
		}
		wdu.waitForPageToLoad(driver);
		driver.manage().window().maximize();
	}
			
		@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
		public void loginApp() throws Throwable {
			String username=data.getPropertyFromKeyValue("username");
			String password=data.getPropertyFromKeyValue("password");
			String url=data.getPropertyFromKeyValue("url");
			
			sDriver=driver;
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(url, username, password);
		}
		
		@AfterMethod(groups = {"SmokeTest","RegressionTest"})
		public void logout() {
			Home hp=new Home(driver);
			hp.getSignOut();
		}
		
		@AfterClass(groups = {"SmokeTest","RegressionTest"})
		public void closeTheBrowser() {
			driver.quit();
		}
		@AfterSuite(groups = {"SmokeTest","RegressionTest"})
		public void closeDbConnection() {
			System.out.println(" Closing DataBase Connection..........");
			
		}
	
}





