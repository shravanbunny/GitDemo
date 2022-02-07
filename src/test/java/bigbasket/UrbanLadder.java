package bigbasket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UrbanLadder {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.urbanladder.com/");
	    driver.manage().window().maximize();
	    
	    WebElement findElement = driver.findElement(By.xpath("//div[@class='taxonNavigation']/div/nav/div/ul/li[2]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(findElement).perform();
	    driver.findElement(By.xpath("//span[text()='Lounge Chairs']")).click();
	    String price= driver.findElement(By.xpath("//a[@title='Genoa Wing Chair (Floral)']/div[2]/span")).getText();
	    
	    driver.findElement(By.xpath("//div[@data-taxon='lounge_chairs']/ul/li[3]/div")).click();
	    
	    System.out.println("price is : "+price);
	    
	    String num="";
	    for(int i=0;i<price.length();i++) {
	    	if(price.charAt(i)>='0' && price.charAt(i)<='9') {
	    		System.out.print(num=num+price.charAt(i));
	    		
	    	}
	    }
	    driver.close();
	}
}
