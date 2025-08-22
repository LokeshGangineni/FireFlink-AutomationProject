package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnotationAttribute {
	
	
	@Test(invocationCount = 2)
	public void Create()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(priority = -1)
	public void Modify()
	{
		System.out.println("modify");
	}
	@Test(dependsOnMethods = "Create",priority = 4)
	public void Delete()
	{
		System.out.println("delete");
	}

}
