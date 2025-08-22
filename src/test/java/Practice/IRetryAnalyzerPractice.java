package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IRetryAnalyzerPractice {
	
	@Test(retryAnalyzer =ninjaCRM.GenericUtility.IRetryImplementation.class)
	public void sample()
	{
		System.out.println("sample");
		Assert.fail();
	
	}

}
