package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.healthWillnessForm;
import PageObjects.specialistPage;
import testBase.Base;
import utilites.ExcelUtility;

public class TC_03 extends Base{
   
	public healthWillnessForm hf;
	public specialistPage sp;
	
	
	@Test(priority=5,groups={"sanity"})
	void checkDemoPageOpened() throws InterruptedException, IOException {
		sp=new specialistPage(driver);
		hf=new healthWillnessForm(driver);
		sp.openHealthform();
		String title=driver.getTitle();
		Assert.assertEquals(title, getProperties().getProperty("demoTitle"));
		captureScreen("DemoPage");
		logger.info("****Starting Testcase five sanity testing****");
		logger.info("**Demo form page opended Successfully**");
	}
	
	
	
	@Test(priority=6,groups={"Regression"},dependsOnMethods= {"checkDemoPageOpened"})
	void validateForm_Invalid_Detials() throws InterruptedException, IOException {
		
		logger.info("****Starting Testcase Six entering invalid detials in form****");
		
		
		scrollDown(hf.scroll);
		hf.formDetials(ExcelUtility.getData(System.getProperty("user.dir")+"\\testData\\testInputData.xlsx", "Sheet1",6 , 0));
	    boolean status=hf.submitButtonStatus();
	    if(!status) {
	    	logger.info("****submit button disabled****");
	    	logger.info("***TestCase three excuted successfully***");
	    }
	    captureScreen("invalidDetials");
	   Assert.assertEquals(status, false);
	}
	
	
}
