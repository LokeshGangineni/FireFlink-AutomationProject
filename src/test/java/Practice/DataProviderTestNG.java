package Practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninjaCRM.GenericUtility.FileUtility;

public class DataProviderTestNG {
	
	@Test(dataProvider ="DataProvider")
	public void checkingDataProvider(String name,int id)
	{
		System.out.println(name+"  "+ id);
	}
	
	@DataProvider
	public Object[][] DataProvider() throws IOException
	{
		FileUtility futil= new FileUtility();
		return futil.readingMultipleDataFromExcel(4, 2, "TestCases");
//		Object [][] data= new Object[3][2];
		
//		data[0][0]="lokesh";
//		data[0][1]=1;
//		
//		
//		data[1][0]="venkat";
//		data[1][1]=2;
//		
//		data[2][0]="harsha";
//		data[2][1]=3;
//		return data;
	}

}
