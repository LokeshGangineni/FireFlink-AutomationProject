package Practice.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninjaCRM.GenericUtility.BaseClass;
import ninjaCRM.ObjectRepository.Campaignspage;
import ninjaCRM.ObjectRepository.CreateCampaginPage;
import ninjaCRM.ObjectRepository.DashboardPage;

public class campaginTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createCampaginTest2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		String CAMPAGINNAME=futil.ReadDataFromExcel("E2E", 31, 2);
		String TARGETSIZE=futil.ReadDataFromExcel("E2E", 31, 3);
		DashboardPage ddp= new DashboardPage(driver);
		ddp.getCampaignsLink().click();
		Campaignspage cp= new Campaignspage(driver);
		cp.getCreateCampaignButton().click();
		CreateCampaginPage ccp= new CreateCampaginPage(driver);
		
		Thread.sleep(2000);
		
		ccp.creatingCampaign(CAMPAGINNAME, TARGETSIZE, driver);
		Thread.sleep(6000);
	}

}
