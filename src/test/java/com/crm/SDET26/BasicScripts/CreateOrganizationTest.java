package com.crm.SDET26.BasicScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationTest {
	
		
public static void main(String[] args) throws Throwable {
	

		//get Random data
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
			
		FileInputStream fis = new FileInputStream("./CommonData.properties");
			
		Properties pobj = new Properties();
		pobj.load(fis);
		String browser=pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
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
		FileInputStream fis1 = new FileInputStream("./data.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);
		
		Sheet sh = book.getSheet("Organization");
		
		Row row = sh.getRow(1);
		
		String orgName = row.getCell(2).getStringCellValue() + ranDomNum;
		//book.close();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String orgname = driver.findElement(By.className("dvHeaderText")).getText();
		
		System.out.println(orgname);
		
		if(orgname.contains(orgName)) {
			System.out.println(orgName + "org creation passed");
		}else {
			System.out.println(orgName + "org creation not passed");
		}
		

		WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		
		Actions act= new Actions(driver);
		
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//driver.close();
	}
	
}

	


