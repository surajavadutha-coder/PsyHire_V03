package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobHiringStagePage extends BasePage{

	public JobHiringStagePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//input[@placeholder='Cut-off Score'])")
	WebElement inpCutoff;
	
	@FindBy(xpath = "(//span[normalize-space()='Assign team'])/../../..")
	WebElement drpAssignTeam;
	
	@FindBy(xpath = "(//input[@placeholder='Search'])")
	WebElement inpSearchAssignTeam;
	
	@FindBy(xpath = "(//div[@role='listbox'])//div[1]//span[1]")
	WebElement btnFirstAssign;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Complete within(days)')]")
	WebElement inpCompleteWithin;
	
	@FindBy(xpath = "(//button[@aria-label='Toggle auto advance'])")
	WebElement togAutoAdvance;
	
	@FindBy(xpath = "(//button[@title='Confirm stage'])")
	WebElement btnConfirmStage;
	
	@FindBy(xpath = "(//span[normalize-space()='Add stage'])/..")
	WebElement drpAddStage;
	
	@FindBy(xpath = "//p[normalize-space()='Pre-Screening Call']/../..")
	WebElement btnPreScreeningCall;
	
	@FindBy(xpath = "(//p[normalize-space()='AI Interview'])/../..")
	WebElement btnAIInterview;
	
	@FindBy(xpath = "(//p[normalize-space()='Technical Interview'])/../..")
	WebElement btnTechnicalInterview;
	
	@FindBy(xpath = "(//p[normalize-space()='Panel Interview'])/../..")
	WebElement btnPanelInterview;
	
	@FindBy(xpath = "(//p[normalize-space()='HR Interview'])/../..")
	WebElement btnHRInterview;
	
	@FindBy(xpath = "(//span[normalize-space()='Next: Review & Publish'])/..")
	WebElement btnNextReviewandPublish;
	
	
	public void configureStage(
	        String cutoff,
	        String team,
	        String completeWithin)
	{
		inpCutoff.clear();
		sendKeys(inpCutoff,cutoff);
		click(drpAssignTeam);
		sendKeys(inpSearchAssignTeam,team);
		click(btnFirstAssign);
		sendKeys(inpCompleteWithin,completeWithin);
	}
	
	
	
	public void fillHiringStages(String cutoff,
	        String team,
	        String completeWithin,
	        String cutoff2,
	        String team2,
	        String completeWithin2) 
	{
		configureStage(cutoff,team,completeWithin);
		click(togAutoAdvance);
		click(btnConfirmStage);
		click(drpAddStage);
		click(btnPreScreeningCall);
		configureStage(cutoff2,team2,completeWithin2);
		click(togAutoAdvance);
		click(btnConfirmStage);
		click(btnNextReviewandPublish);
	}
	
//	public void setCutoff(String score) {
//		inpCutoff.clear();
//		inpCutoff.sendKeys(score);
//	}
//	
//	public void setAssignTeam(String name) throws InterruptedException {
//		drpAssignTeam.click();
//		Thread.sleep(500);
//		inpSearchAssignTeam.sendKeys(name);
//		Thread.sleep(500);
//		btnFirstAssign.click();
//	}
//	
//	public void setCompleteWithin(String days) {
//		inpCompleteWithin.sendKeys(days);
//	}
//	
//	public void clickAutoAdvance() {
//		click(togAutoAdvance);
//	}
//	
//	public void clickConfirmStage() {
//		click(btnConfirmStage);
//	}
//	
//	public void clickAddStage() {
//		click(drpAddStage);
//	}
//	
//	public void clickPreScreeningCall() {
//		click(btnPreScreeningCall);
//	}
//	
//	public void clickNextReviewandPublish() {
//		click(btnNextReviewandPublish);
//	}
	
}
