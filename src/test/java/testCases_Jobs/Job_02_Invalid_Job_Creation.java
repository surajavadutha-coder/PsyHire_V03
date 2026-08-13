package testCases_Jobs;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.JobBasicsPage;
import pageObjects.JobsActivePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Job_02_Invalid_Job_Creation extends BaseClass{
	
	@Test(dataProvider = "JobDataWithoutTitle",dataProviderClass= DataProviders.class)
	public void verify_job_Creation_with_invalid_data(String Jobtitle, String Industry, String Sub_industry, String Location, String Workstyle, String Employment,
			String EXPfrom, String EXPto, String Openings, String Currency, String Salaryfrom, String Salaryto, String Yearly, String Deadline) throws InterruptedException {
		logger.info("**Started Job_02_Invalid_Job_Creation ***");
		try {
		login();
		
		JobsActivePage jb = new JobsActivePage(driver);
		jb.clickJobs();
		jb.clickPostAJob();
		
		//------------------------basics page------------------------------
		JobBasicsPage jbb = new JobBasicsPage(driver);
		
		jbb.fillBasicsDetailsWithoutTitle(Jobtitle,Industry, Sub_industry, Location, Workstyle, Employment, EXPfrom, EXPto, Openings, Currency, Salaryfrom, Salaryto, Yearly, Deadline);
		boolean target = jbb.isJobTitleErrorExists();
		
		Assert.assertTrue(target);
		
		}catch(Exception e) {
			logger.error(e.getMessage());
		    Assert.fail(e.getMessage());
		}
		logger.info("**Finished Job_02_Invalid_Job_Creation ***");
	}
	
	
	
}
