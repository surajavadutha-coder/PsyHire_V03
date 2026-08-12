package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_03_Expired extends BaseClass{
	
	@Test
	public void verify_Expired_OTP() 
	{
		logger.info("**Started AUT_03_Expired ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			
			Thread.sleep(310000);
			lp.setOTP("0");
			lp.clickVerify();
		
			
			Thread.sleep(500);
			boolean target = lp.isInvalid();
			
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished AUT_03_Expired ***");
	}

}
