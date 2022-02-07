package bigbasket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BigBasket {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement bevElement = driver.findElement(By.xpath("//a[@qa='categoryDD']"));
	
		

		
		Actions act = new Actions(driver);
		
		act.moveToElement(bevElement).perform();
		 driver.findElement(By.xpath("(//a[text()='Beverages'])[2]")).click();
		
		List<WebElement> bevListElements = driver.findElements(By.tagName("//img"));
		int count=0;
		for(WebElement wb : bevListElements)
		{
			System.out.println(wb.getText());
			count++;
		}
		System.out.println(count);
		
		driver.findElement(By.xpath("(//span[text()='Coffee'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Ground Coffee'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='pd-icon-wrap'])[1]/..")).click();
		
		
		
		String mrp=driver.findElement(By.xpath("//div[@id='title']/div[1]/div/table/tbody/tr[2]/td[2]")).getText();
		
		System.out.println(mrp);
		
		String rateOfProduct=driver.findElement(By.xpath("//div[@id='title']/div[1]/div/table/tbody/tr[1]/td[2]")).getText();
		System.out.println(rateOfProduct);
	
		
		
		
		String text = driver.findElement(By.xpath("//div[@id='title']/div[1]/div/table/tbody/tr[3]/td[2]")).getText();
		System.out.println(text);
		
//		SoftAssert soft=new SoftAssert();
//		soft.assertEquals(mrp,rateOfProduct,);

		driver.close();
	}

}
