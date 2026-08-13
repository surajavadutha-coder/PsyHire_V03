package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobBasicsPage extends BasePage{

	public JobBasicsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Job title']")
	WebElement inpJobTitle;
	
	@FindBy(xpath = "//span[normalize-space()='Select industry & sub-industry']/..")
	WebElement drpSelectIndustry;
	
//	@FindBy(xpath="//input[@placeholder='Search']")
//	WebElement searchBox;
//	
//	@FindBy(xpath="(//div[@role='listbox'])//div[1]//span[1]")
//	WebElement firstOption;
	
	private By searchBox =
	        By.xpath("//input[@placeholder='Search']");

	private By firstOption =
	        By.xpath("(//div[@role='listbox'])//div[1]//span[1]");
	
	@FindBy(xpath = "//input[@placeholder = 'Search sub-industry']")
	WebElement inpSearchSubIndustry;
	
	@FindBy(xpath = "(//div[contains(@class,'overflow-auto')])[2]//button[1]")
	WebElement btnFirstOption ;
		
	@FindBy(xpath = "(//span[normalize-space()='Select location'])/../../..")
	WebElement drpLocation;
	
	@FindBy(xpath = "(//span[normalize-space()='Select work style'])/../../..")
	WebElement drpWorkStyle;
	
	@FindBy(xpath = "(//span[normalize-space()='Employment type'])/../../..")
	WebElement drpEmployementType;
	
	@FindBy(xpath = "(//span[normalize-space()='Experience optional'])/../../..")
	WebElement drpExperience;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement inpFromExperience;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement inpToExperience;
	
	@FindBy(xpath = "(//span[normalize-space()='No. of openings'])/..//input")
	WebElement inpOpenings;
	
	@FindBy(xpath = "(//span[normalize-space()='Currency'])/../../..")
	WebElement drpCurrency;
	
	@FindBy(xpath = "(//span[normalize-space()='Salary range'])/../../..")
	WebElement drpSalaryRange;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement inpFromSalary;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement inpToSalary;
	
	@FindBy(xpath = "(//span[normalize-space()='e.g. Yearly'])/../../..")
	WebElement drpYearly;
	
	@FindBy(xpath = "(//span[normalize-space()='Select a date'])/..")
	WebElement DateDeadline;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit Details'])/..")
	WebElement btnSubmitDetails;
	
	@FindBy(xpath = "//p[.='Job title is required']")
	WebElement txtJobTitleError;
	
	
	private void searchAndSelect(String value) throws InterruptedException
	{	
		Thread.sleep(500);
	    WebElement search =
	            wait.until(ExpectedConditions.refreshed(
	                ExpectedConditions.elementToBeClickable(searchBox)));

	    search.sendKeys(value);
	    Thread.sleep(1000);
	    WebElement option =
	            wait.until(
	                ExpectedConditions.elementToBeClickable(firstOption));

	    option.click();
	}
	
	public void fillBasicsDetails( String jobTitle,
	        String industry,
	        String subIndustry,
	        String location,
	        String workStyle,
	        String employment,
	        String expFrom,
	        String expTo,
	        String openings,
	        String currency,
	        String salaryFrom,
	        String salaryTo,
	        String yearly,
	        String deadline) throws InterruptedException 
	{
		sendKeys(inpJobTitle, jobTitle);
		
		click(drpSelectIndustry);
		click(driver.findElement(By.xpath("(//div[@class='max-h-[335px] overflow-auto border-r border-border-secondary bg-[var(--greys-elevation-2)] p-(--space-3)'])//button["+industry+"]")));
		sendKeys(inpSearchSubIndustry,subIndustry);
		click(btnFirstOption);
		
		click(drpLocation);
		searchAndSelect(location);
		
		click(drpWorkStyle);
		searchAndSelect(workStyle);
		
		click(drpEmployementType);
		searchAndSelect(employment);
		
		click(drpExperience);
		sendKeys(inpFromExperience,expFrom);
		sendKeys(inpToExperience,expTo);
		
		sendKeys(inpOpenings,openings);
		
		click(drpCurrency);
		searchAndSelect(currency);
		
		click(drpSalaryRange);
		sendKeys(inpFromSalary,salaryFrom);
		sendKeys(inpToSalary,salaryTo);
		
		click(drpYearly);
		searchAndSelect(yearly);
		
		click(DateDeadline);
		click(driver.findElement(By.xpath("(//span[normalize-space()='"+deadline+"'])/..")));
		click(btnSubmitDetails);
	}
	
	public void fillBasicsDetailsWithoutTitle(String jobTitle,
	        String industry,
	        String subIndustry,
	        String location,
	        String workStyle,
	        String employment,
	        String expFrom,
	        String expTo,
	        String openings,
	        String currency,
	        String salaryFrom,
	        String salaryTo,
	        String yearly,
	        String deadline) throws InterruptedException 
	{
		
		
		click(drpSelectIndustry);
		click(driver.findElement(By.xpath("(//div[@class='max-h-[335px] overflow-auto border-r border-border-secondary bg-[var(--greys-elevation-2)] p-(--space-3)'])//button["+industry+"]")));
		sendKeys(inpSearchSubIndustry,subIndustry);
		click(btnFirstOption);
		
		click(drpLocation);
		searchAndSelect(location);
		
		click(drpWorkStyle);
		searchAndSelect(workStyle);
		
		click(drpEmployementType);
		searchAndSelect(employment);
		
		click(drpExperience);
		sendKeys(inpFromExperience,expFrom);
		sendKeys(inpToExperience,expTo);
		
		sendKeys(inpOpenings,openings);
		
		click(drpCurrency);
		searchAndSelect(currency);
		
		click(drpSalaryRange);
		sendKeys(inpFromSalary,salaryFrom);
		sendKeys(inpToSalary,salaryTo);
		
		click(drpYearly);
		searchAndSelect(yearly);
		
		click(DateDeadline);
		click(driver.findElement(By.xpath("(//span[normalize-space()='"+deadline+"'])/..")));
		click(btnSubmitDetails);
	}
	
	public boolean isJobTitleErrorExists() throws InterruptedException {
		
		if(getText(txtJobTitleError).equals("Job title is required")) {
			return true;
		}
		return false;
	}
	
	
	//------------------------------------------JD and Skills--------------------------------------
	
	@FindBy(xpath = "(//p[normalize-space()='Skills Required'])")
	WebElement txtHeadingSkills;
	
	@FindBy(xpath = "//span[normalize-space()='Next: Competencies']/..")
	WebElement btnNextComp;
	
	@FindBy(xpath = "//div[@class=\"text-[15px] leading-7 text-text-main\"]/p")
	WebElement txtJDSummary;
	
	@FindBy(xpath = "(//div[@class='custom-scrollbar flex h-full min-h-0 flex-wrap content-start gap-(--space-3) overflow-y-auto pr-(--space-2)'])/span/span")
	List<WebElement> txtSkills;
	
	
	
	public boolean isDisplayedSkills() {
		if(txtHeadingSkills.getText().equals("Skills Required")) {
			return true;
		}
		return false;
	}
	
	public int isJDRelated(String jobTitle,List<String> expectedSkills) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(driver ->
        "false".equals(btnNextComp.getAttribute("aria-disabled"))
			);
		int Count = 0 ;
		if(getText(txtJDSummary).toLowerCase().contains(jobTitle.toLowerCase())) {
			for (WebElement skill : txtSkills){
				for(String expectedskill:expectedSkills) {
					if(getText(skill).contains(expectedskill)) {
						Count++;
						break;
					}
				}
			}
		}
		btnNextComp.click();
		return Count;

	}
	
	
	public void clickNextCompWhenEnabled() {

	    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(driver ->
	        "false".equals(btnNextComp.getAttribute("aria-disabled"))
	    );
	    btnNextComp.click();
	}
}
