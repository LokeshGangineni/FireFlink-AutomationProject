package Practice.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninjaCRM.GenericUtility.BaseClass;
import ninjaCRM.ObjectRepository.Campaignspage;
import ninjaCRM.ObjectRepository.CreateCampaginPage;
import ninjaCRM.ObjectRepository.DashboardPage;

@Listeners(ninjaCRM.GenericUtility.ListernersImplementation.class)
public class campagincreating extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createCampaginTest2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		String CAMPAGINNAME=futil.ReadDataFromExcel("E2E", 31, 2);
		String TARGETSIZE=futil.ReadDataFromExcel("E2E", 31, 3);
		DashboardPage ddp= new DashboardPage(driver);
		ddp.getCampaignsLink().click();
		Reporter.log("clicked on create campagin link ",true);
		Campaignspage cp= new Campaignspage(driver);
		cp.getCreateCampaignButton().click();
		Reporter.log("clicked on create campagin button ",true);
		CreateCampaginPage ccp= new CreateCampaginPage(driver);
		
		Thread.sleep(2000);
		
		ccp.creatingCampaign(CAMPAGINNAME, TARGETSIZE, driver);
		Thread.sleep(6000);
	}
	
	@Test(groups = "RegressionSuite")
	public void sample()
	{
		Assert.fail();
		System.out.println("sample done");
	}

}
