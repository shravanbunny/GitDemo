package com.crm.SDET26.BasicScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commongenericdata.DataUtility;

public class CreateContactsWithOrganizationTest {
	
		public static void main(String[] args) throws Throwable {
			
				Random ran = new Random();
				int ranDomNun = ran.nextInt(10000);

			
			FileInputStream fis = new FileInputStream("./CommonData.properties");
			
			Properties pobj = new Properties();
			pobj.load(fis);
			String browser=pobj.getProperty("browser");
			String url = pobj.getProperty("url");
			String username = pobj.getProperty("username");
			String password = pobj.getProperty("password");
			
			
			FileInputStream fis1 = new FileInputStream("./data.xlsx");
			
			Workbook book = WorkbookFactory.create(fis1);
			
			Sheet sh = book.getSheet("Contacts");
			
			Row row = sh.getRow(1);
			
			String contact= row.getCell(2).getStringCellValue() +ranDomNun;
			
		    String orgName = row.getCell(3).getStringCellValue() + ranDomNun; 
		    
			book.close();

			WebDriver driver = null;
			if(browser.equals("chrome")) {
				
				driver=new ChromeDriver();
			}else if(browser.equals("edge")) {
				
				driver=new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
			
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			
	         WebElement headerWb = driver.findElement(By.className("dvHeaderText"));
	         WebDriverWait wait = new WebDriverWait(driver, 20);
	         wait.until(ExpectedConditions.elementToBeClickable(headerWb));

			
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(contact);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
        driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
        
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();

         while (it.hasNext()) {
		          String wID = it.next();
		          driver.switchTo().window(wID);
		          String currentWindowTitle = driver.getTitle();
		          if(currentWindowTitle.contains("Accounts")) {
		        	  break;
		          }
	    	}
         
         driver.findElement(By.name("search_text")).sendKeys(orgName);
         
         driver.findElement(By.name("search")).click();
         driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
         
         Set<String> set1 = driver.getWindowHandles();
         Iterator<String> it1 = set1.iterator();
         while (it1.hasNext()) {
	          String wID = it1.next();
	          driver.switchTo().window(wID);
	          String currentWindowTitle = driver.getTitle();
	          if(currentWindowTitle.contains("Contacts")) {
	        	  break;
	          }
   	}
         


		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//driver.close();
	}

}
