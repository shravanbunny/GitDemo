package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestScript {
	
		public static void main(String[] args) {
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.bluestone.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			WebElement rings = driver.findElement(By.xpath("//a[text()='Rings ']"));
			
			Actions act = new Actions(driver);
			act.moveToElement(rings).perform();
			
			driver.findElement(By.xpath("//a[text()='Engagement']")).click();
			
			WebElement price = driver.findElement(By.xpath("//span[text()='Price']"));
			
			act.moveToElement(price).perform();
			
			driver.findElement(By.xpath("//span[text()=' 20,000 - ']")).click();
			
			System.out.println("done by gitx user1");
			System.out.println("done by gitx user2");
			System.out.println("done by gitx user3");
			System.out.println("done by user 4");
			System.out.println("done by user 5");
			
			
			
			
		}

}
