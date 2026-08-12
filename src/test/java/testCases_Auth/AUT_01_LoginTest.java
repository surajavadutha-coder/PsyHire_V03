package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.JobsActivePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_01_LoginTest extends BaseClass{
	
	@Test
	public void verify_login() 
	{
		logger.info("**Started TC_01_LoginTest ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			lp.setOTP("0");
			lp.clickVerify();

			
			JobsActivePage jobsA = new JobsActivePage(driver);
			boolean target = jobsA.isJobsExist();
			
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished TC_01_LoginTest ***");
	}
}