package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsActivePage extends BasePage{

	public JobsActivePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/jobs']")
	WebElement btnJobs;
	
	@FindBy(xpath = "//span[normalize-space()='Post a Job']/..")
	WebElement btnPostAJob;
	
	@FindBy(xpath = "//input[@placeholder='Search by job title, ID, location']")
	WebElement inpSearch;
	
	@FindBy(xpath = "(//img[@alt='grid switcher icon'])[1]/..")
	WebElement btnGrid;
	
	@FindBy(xpath = "(//img[@alt='grid switcher icon'])[2]/..")
	WebElement btnList;
	
//	------------------------------Active-----------------------------------
	
	@FindBy(xpath = "//span[normalize-space()='Active']/..")
	WebElement btnActive;
	
	@FindBy(xpath = "(//img[@alt='job info icon'])[1]/..")
	WebElement btnInfo;
	
	@FindBy(xpath = "(//div[contains(@class,'mt-1 flex items-center gap-2')])[1]/pre")
	WebElement txtJobID;
	
	@FindBy(xpath = "(//h5)[1]")
	WebElement txtJobTitle;
//	------------------------------Paused-----------------------------------
	@FindBy(xpath = "//span[normalize-space()='Paused']/..")
	WebElement btnPaused;
//	------------------------------Draft------------------------------------
	@FindBy(xpath = "//span[normalize-space()='Draft']/..")
	WebElement btnDraft;
//	------------------------------Archived---------------------------------
	@FindBy(xpath = "//span[normalize-space()='Archived']/..")
	WebElement btnArchived;
	
	public void clickJobs() {
		click(btnJobs);
	}
	
	public void clickPostAJob() {
		click(btnPostAJob);
	}
	
	public String getJobID() {
		return txtJobID.getText();
	}
	
	public String getJobTitle() {
		return txtJobTitle.getText();
	}
	
	
}
