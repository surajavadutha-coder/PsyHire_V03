
	
	import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

	public class dummyextent implements ITestListener
	{
	
		public ExtentSparkReporter sparkReporter; // UI of the report
		public ExtentReports extent; // populate common info on the report
//		public ExtentTest test; //creating test case entries and update status of the test methods
		ThreadLocal<ExtentTest> test = new ThreadLocal<>();
		
		
		String repName;
		
		public void onStart(ITestContext testcontext) {
		    
//			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//			Date dt = new Date();
//			String currentdatestamp = df.format(dt);
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName = "Test-Report-"+ timeStamp + ".html";
			sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
			
			sparkReporter.config().setDocumentTitle("psyHire Automation Report");
			sparkReporter.config().setReportName("psyHire Functional Testing");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Application", "psyHire");
//			extent.setSystemInfo("Module", "Login");
//			extent.setSystemInfo("Sub Module", "Login_functionality");
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			
			String os = testcontext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			
			String browser = testcontext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			
			List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
				extent.setSystemInfo("Groups", includedGroups.toString());
			}
			
		  }
		
//		public void onTestStart(ITestResult result) {
//			
//		  }
		
		@Override
		public void onTestStart(ITestResult result)
		{
			ExtentTest extentTest =
			        extent.createTest(result.getMethod().getMethodName());

			test.set(extentTest);

		    test.get().assignCategory(result.getMethod().getGroups());
		    test.get().info("Test Started");
		}
		
		public void onTestSuccess(ITestResult result) {
			test.get().pass("Successfully executed: "
	                + result.getName());
		  }
		
		public void onTestFailure(ITestResult result) {
			test.get().fail(result.getThrowable());
//			test.log(Status.INFO, "Successfully executed:"+ result.getThrowable().getMessage());
			try {
				String imgPath = new BaseClass().captureScreen(result.getName());
				test.get().addScreenCaptureFromPath(imgPath);
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		
		}
		 
		public void onTestSkipped(ITestResult result) {
			test.get().skip(result.getThrowable());
//			test.log(Status.INFO,result.getThrowable().getMessage());
		  }
		
		public void onFinish(ITestContext testcontext) {
			extent.flush();
			
			String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			}catch(IOException e) {
				e.printStackTrace();
			}
		  }
}
