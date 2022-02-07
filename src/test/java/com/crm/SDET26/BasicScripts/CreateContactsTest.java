package com.crm.SDET26.BasicScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import commongenericdata.DataUtility;

public class CreateContactsTest {
	
	public static void main(String[] args) throws Throwable {
		
		
		
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
		
		String contact= row.getCell(2).getStringCellValue();
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
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(contact);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String createdcontact = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(createdcontact.contains(contact)) {
			System.out.println(contact + "created successfully");
		}else {
			System.out.println(contact + "created successfully");
		}
		
		WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(signout).perform();		
		driver.findElement(By.linkText("Sign Out")).click();;
		
		//driver.close();
		}
	}
