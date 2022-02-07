package com.crm.com.crm.SDET;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonValidation {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("user is on amazon homepage");
		}else {
			System.out.println("user is on amazon homepage");
		}
		
		 int upper = 0, lower = 0, number = 0, special = 0;
		    for (int i = 0; i < title.length(); i++)
		    {
		        if (title.charAt(i) >= 'A' && title.charAt(i) <= 'Z')
		            upper++;
		        else if (title.charAt(i) >= 'a' &&title.charAt(i) <= 'z')
		            lower++;
		        else if (title.charAt(i)>= '0' && title.charAt(i)<= '9')
		            number++;
		        else
		            special++;
		    }
		    System.out.println("UpperCase letter :" + upper);
		    System.out.println("LowerCase letter :" + lower);
		    System.out.println("numbers present :" + number);
		    System.out.println("special character present  :" + special);
		    
		
	}

}
