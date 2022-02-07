package com.crm.SDET26.BasicScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commongenericdata.DataUtility;

public class CreateContactsWithOrgNameAndLeadTest {
	
	@Test
	public void createContactsWithOrgNameAndLeadTes() throws IOException {
		
//		FileInputStream fis = new FileInputStream("E:\\OCSE5\\DataStorage\\CommonData.properties");
//		
//		Properties pobj = new Properties();
//		
//		pobj.load(fis);
//		
//		String url = pobj.getProperty("url");
//		
//		String username = pobj.getProperty("username");
//		
//		String password = pobj.getProperty("password");
//		
//		String browser = pobj.getProperty("browser");
		
		DataUtility data = new DataUtility();
		
		WebDriver driver=null;
		
		if(data.getDataFromProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\OCSE5\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(data.getDataFromProperty("broswer").equals("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\OCSE5\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperty("url"));
	
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys(data.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(data.getDataFromProperty("password"));
		
		driver.findElement(By.id("submitButton")).click();
		
		
		
		
//		System.setProperty("webdriver.chrome.driver", "E:\\OCSE5\\chromedriver_win32\\chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://localhost:8888/");
//		
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.name("user_name")).sendKeys("admin" , Keys.TAB , "root" , Keys.TAB , Keys.ENTER);
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		String mainID = driver.getWindowHandle();
		
		Set<String> allid = driver.getWindowHandles();
		
		for(String id:allid) {
			if(!mainID.equals(id)) {
				driver.switchTo().window(id);
			}
		}
		
		driver.findElement(By.linkText("demovtiger")).click();
		
		driver.switchTo().window(mainID);
		
		WebElement leadsrc = driver.findElement(By.name("leadsource"));
		
		Select s = new Select(leadsrc);
		
		s.selectByValue("Employee");
		
		driver.findElement(By.name("emailoptout")).click();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
