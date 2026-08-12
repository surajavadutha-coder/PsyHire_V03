package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.JobsActivePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_04_Resend extends BaseClass{
	
	@Test
	public void verify_Resend_OTP() 
	{
		logger.info("**Started AUT_04_Resend ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			Thread.sleep(310000);
			lp.clickResend();
			lp.setOTP("0");
			lp.clickVerify();
		
			JobsActivePage jobsA = new JobsActivePage(driver);
			boolean target = jobsA.isJobsExist();
			
			Thread.sleep(2000);
			
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished AUT_04_Resend ***");
	}
	
}
