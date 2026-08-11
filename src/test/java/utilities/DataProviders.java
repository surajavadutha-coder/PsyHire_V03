package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="JobData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\JobData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String jobdata[][] = new String[totalrows][totalcols];
		
		for(int i = 1; i<=totalrows; i++)
		{
			for(int j = 0; j<totalcols ; j++)
			{
				jobdata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return jobdata;
	}
	
	@DataProvider(name="HiringStageData")
	public String[][] getHSData() throws IOException
	{
		String path = ".\\testData\\JobData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols = xlutil.getCellCount("Sheet2", 1);
		
		String jobdata[][] = new String[totalrows][totalcols];
		
		for(int i = 1; i<=totalrows; i++)
		{
			for(int j = 0; j<totalcols ; j++)
			{
				jobdata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return jobdata;
	}
}