package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Hola Amigo!!']")
	WebElement txtHola;
	
	@FindBy(xpath = "//span[normalize-space()='Profile']/..")
	WebElement btnProfile;
	
	@FindBy(xpath = "//span[normalize-space()='Logout']/..")
	WebElement btnLogout;
	
	@FindBy(xpath = "//span[normalize-space()='Log out']/..")
	WebElement btnLogoutModal;
	
	public boolean isDashboardexists() {
		if(txtHola.getText().equals("Hola Amigo!!")) {
			return true;
		}
		return false;
	}
	
	
	
	public void clickProfile() {
		btnProfile.click();
	}
	
	public void clickLogout() throws InterruptedException {
		btnLogout.click();
		Thread.sleep(2000);
		btnLogoutModal.click();
		
	}
	
}
