package testCases_Jobs;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.JobBasicsPage;
import pageObjects.JobsActivePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Job_03_Validate_JD_Skills extends BaseClass{
	
	@Test(dataProvider = "JobandSkillData", dataProviderClass = DataProviders.class )
	public void validate_generated_jd_skills(String Jobtitle, String Industry, String Sub_industry, String Location, String Workstyle, String Employment,
			String EXPfrom, String EXPto, String Openings, String Currency, String Salaryfrom, String Salaryto, String Yearly, String Deadline,String ExpectedSkills ) 
	{
		logger.info("*** Started Job_03_Validate_JD_Skills ***");
		try {
			login();
			
			JobsActivePage jb = new JobsActivePage(driver);
			jb.clickJobs();
			jb.clickPostAJob();
			
			//------------------------basics page------------------------------
			JobBasicsPage jbb = new JobBasicsPage(driver);
			
			jbb.fillBasicsDetails(Jobtitle, Industry, Sub_industry, Location, Workstyle, Employment, EXPfrom, EXPto, Openings, Currency, Salaryfrom, Salaryto, Yearly, Deadline);
			List<String> expectedSkillsList = Arrays.stream(ExpectedSkills.split(","))
		              .map(String::trim)
		              .toList();
			int target = jbb.isJDRelated(Jobtitle,expectedSkillsList);
//			System.out.println(target);
			Assert.assertTrue(4<=target);
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		logger.info("**Finished Job_03_Validate_JD_Skills ***");
	}
	
	
}
