package testCases_Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class AUT_05_Unregistered_Email extends BaseClass{
	
	@Test
	public void verify_Unregistered_Email() 
	{
		logger.info("**Started AUT_05_Unregistered_Email ***");
		try 
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("unregistered_email"));
			lp.clickSubmit();
					
			
			Thread.sleep(1000);
			boolean target = lp.toastUnauthMail();
			
			Thread.sleep(1000);
			
			Assert.assertTrue(target);
			
			
		}catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished AUT_05_Unregistered_Email ***");
	}

}
