package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_02_Invalid_OTP extends BaseClass{
	
	@Test
	public void verify_invalid_login() 
	{
		logger.info("**Started AUT_02_Invalid_OTP ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			lp.setOTP("A");
			lp.clickVerify();

			
			Thread.sleep(1000);
			
			boolean target = lp.isInvalid();
			
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("**Finished AUT_02_Invalid_OTP ***");
	}

}
