package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_07_Logout_clears extends BaseClass{
	
	@Test
	public void verify_Logout_clears() 
	{
		logger.info("**Started AUT_07_Logout_clears ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.clickSubmit();
			lp.setOTP("0");
			lp.clickVerify();
			
			Thread.sleep(2000);

			DashboardPage db = new DashboardPage(driver);
			db.clickProfile();
			db.clickLogout();
			
			Thread.sleep(3000);
			
			
			Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"User was not redirected to login page after logout");
			
			
			driver.get(p.getProperty("appURL")+"/dashboard");
			Thread.sleep(1000);
			
			Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Unauthorized user was able to access dashboard");
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished AUT_07_Logout_clears ***");
	}

}
