package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobReviewandPublishPage extends BasePage{

	public JobReviewandPublishPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Publish']/..")
	WebElement btnPublish;
	
	@FindBy(xpath = "(//span[normalize-space()='Publish']/parent::button)[2]")
	WebElement btnPublish2;
	
	
	public void clickPublish() throws InterruptedException {
		click(btnPublish);
		
		click(btnPublish2);
	}
	
	
}
