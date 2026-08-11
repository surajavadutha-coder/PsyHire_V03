import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dummy {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
//		
		driver.get("https://psyhiredev.qa.psyhire.aptagrim.co.uk/jobs/PSY001J39/edit");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//input[@placeholder='Enter your email address']")).sendKeys("psyhiredev@web-library.net");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		Thread.sleep(2000);
//		
//		List<WebElement> OTPP = driver.findElements(By.xpath("(//input[contains(@type,'text')])"));
//		
//		for(WebElement otp : OTPP) {
//			otp.clear();
//			otp.sendKeys("0");
//		}
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[normalize-space()='Profile']/..")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[normalize-space()='Logout']/..")).click();
//		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.xpath("(//span[normalize-space()='Next: JD & Skills'])/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[normalize-space()='Next: Competencies'])/..")).click();
		
		
//		driver.quit();
	}

}
