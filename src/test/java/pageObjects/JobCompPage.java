package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobCompPage extends BasePage{

	public JobCompPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[normalize-space()='Next: Hiring Stages'])/..")
	WebElement btnNextHire;
	
	public void clickNextHireWhenEnabled() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(btnNextHire));
        wait.until(driver ->
        "false".equals(btnNextHire.getAttribute("aria-disabled")));
    
        btnNextHire.click();
    }
	
//	public void clickNextHireWhenEnabled() throws InterruptedException {
//		Thread.sleep(10000);
//		click(btnNextHire);
//	}
}
