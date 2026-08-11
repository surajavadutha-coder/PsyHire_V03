package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Enter your email address']")
	WebElement inpEmail;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "(//input[contains(@type,'text')])")
	List<WebElement> inpOTP;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement btnVerify;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement toast;
	
	@FindBy(xpath = "//button[.='Resend']")
	WebElement btnResend;
	
	@FindBy(xpath = "//h3[normalize-space()='Unauthorized Account']")
	WebElement txtUnauth;
	
	
	
	public void setEmail(String mail) {
		inpEmail.clear();
		inpEmail.sendKeys(mail);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void setOTP(String otp) {
		for(WebElement input : inpOTP) {
			input.clear();
			input.sendKeys(otp);;
		}
		
	}
	
	public void clickVerify() {
		btnVerify.click();
	}
	
	public boolean isInvalid() {
		return toast.isDisplayed();
	}
	
	public boolean toastUnauthMail() {
		if(txtUnauth.getText().equals("Unauthorized Account")) {
			return true;
		}
		return false;
	}
	
	
	public void clickResend() {
		btnResend.click();
	}
}
