package bigbasket;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKart {
public static void main(String[] args) { 
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	
	driver.findElement(By.className("_2doB4z")).click();
	
	driver.findElement(By.name("q")).sendKeys("iphone");
	driver.findElement(By.className("L0Z3Pu")).submit();
	WebElement findElement = driver.findElement(By.xpath("(//div[@class='gUuXy-'])[1]"));
    WebDriverWait wait=new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(findElement));
    findElement.click();
    
    String mainId=driver.getWindowHandle();
    Set<String> allId = driver.getWindowHandles();
    
    for(String str: allId) {
    	
    	if(mainId!=str) {
    		driver.switchTo().window(str);
    	}
    	
    	
    }
 
  
    WebElement findElement2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	
	findElement2.click();
	
	driver.quit();
	
}
}
