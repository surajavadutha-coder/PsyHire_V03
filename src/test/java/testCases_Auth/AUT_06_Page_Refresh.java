package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.JobsActivePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_06_Page_Refresh extends BaseClass{
	
	@Test
	public void verify_Page_Refresh() 
	{
		logger.info("**Started AUT_06_Page_Refresh ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			lp.setOTP("0");
			lp.clickVerify();

			Thread.sleep(2000);
			
			refreshPage();
			
			JobsActivePage jobsA = new JobsActivePage(driver);
			boolean target = jobsA.isJobsExist();
	
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished AUT_06_Page_Refresh ***");
	}
	
}
