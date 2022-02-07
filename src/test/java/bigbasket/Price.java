package bigbasket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Price {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		WebElement category = driver.findElement(By.xpath("//a[@qa='categoryDD']"));
		act.moveToElement(category).perform();
		
		Thread.sleep(2000);		
		WebElement brewrage = driver.findElement(By.xpath("(//a[text()='Beverages'])[2]"));
		act.moveToElement(brewrage).perform();
		
		List<WebElement> elements = driver.findElements(By.xpath("(//a[text()='Energy & Soft Drinks'])[2]/../.."));
		
		
		for(WebElement wb:elements) {
			System.out.println(wb.getText());
		
		}
		System.out.println(elements.size());
		
		WebElement cofee = driver.findElement(By.xpath("//a[text()='Coffee']"));
		act.moveToElement(cofee).perform();
		driver.findElement(By.xpath("//a[text()='Ground Coffee']")).click();
		
		
		//driver.close();
	}
}

