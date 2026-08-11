package testCases_Jobs;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.JobBasicsPage;
import pageObjects.JobCompPage;
import pageObjects.JobHiringStagePage;
import pageObjects.JobReviewandPublishPage;
import pageObjects.JobsActivePage;
import pageObjects.Logout;
import testBase.BaseClass;
import utilities.DataProviders;

public class Job_01_Create_Job extends BaseClass{
	
	@Test(dataProvider = "JobData", dataProviderClass=DataProviders.class)
	public void verify_job_creation(String Jobtitle, String Industry, String Sub_industry, String Location, String Workstyle, String Employment,
									String EXPfrom, String EXPto, String Openings, String Currency, String Salaryfrom, String Salaryto, String Yearly, String Deadline) 
	{
		logger.info("**Started Job_01_Create_Job ***");
		try 
		{
			
			login();
			
			
			JobsActivePage jb = new JobsActivePage(driver);
			
			jb.clickJobs();
			
			jb.clickPostAJob();
			
			//------------------------basics page------------------------------
			JobBasicsPage jbb = new JobBasicsPage(driver);
			
			jbb.fillBasicsDetails(Jobtitle, Industry, Sub_industry, Location, Workstyle, Employment, EXPfrom, EXPto, Openings, Currency, Salaryfrom, Salaryto, Yearly, Deadline);
			jbb.clickNextCompWhenEnabled();
			
			//-----------------------Competences-----------------------------------
			JobCompPage comp = new JobCompPage(driver);
			comp.clickNextHireWhenEnabled();
			
			Thread.sleep(1000);
			//-----------------------Hiring Stages-----------------------------------
			JobHiringStagePage HS = new JobHiringStagePage(driver);
			
			HS.fillHiringStages("50","test","2","50","test","2");
			
			
			//---------------------Review and Publish---------------------------
			JobReviewandPublishPage RP = new JobReviewandPublishPage(driver);
			RP.clickPublish();
			
			//---------------------------LogOut---------------------------
			Logout L = new Logout(driver);
			L.Logout();
			
			
			Assert.assertEquals(
				    jb.getJobTitle(),
				    Jobtitle,
				    "Job title mismatch"
				);
			
		}catch(Exception e) 
		{
			logger.error(e.getMessage());
		    Assert.fail(e.getMessage());
		}
		logger.info("**Finished Job_01_Create_Job ***");
	
	}
}
