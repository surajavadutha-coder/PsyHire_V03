package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout extends BasePage{

	public Logout(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@title='admin']")
	WebElement btnProfile;
	
	@FindBy(xpath = "//span[normalize-space()='Logout']/..")
	WebElement btnLogout;
	
	@FindBy(xpath = "//span[normalize-space()='Log out']/..")
	WebElement btnConfirmLogout;
	
	
	public void Logout() {
		click(btnProfile);
		click(btnLogout);
		click(btnConfirmLogout);
	}
	
	
}
