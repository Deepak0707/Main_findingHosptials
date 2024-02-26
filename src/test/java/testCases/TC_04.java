package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.healthWillnessForm;
import PageObjects.specialistPage;
import testBase.Base;
import utilites.ExcelUtility;

public class TC_04 extends Base{
	public healthWillnessForm hf;
	public specialistPage sp;
	
	@Test(priority=7,groups={"sanity"})
	void checkDemoPageOpened() throws InterruptedException, IOException {
		sp=new specialistPage(driver);
		hf=new healthWillnessForm(driver);
		sp.openHealthform();
		String title=driver.getTitle();
		Assert.assertEquals(title, getProperties().getProperty("demoTitle"));
		captureScreen("DemoPage");
		logger.info("****Starting Testcase Seven sanity testing****");
		logger.info("**Practo Url opended Successfully**");
	}
	
	@Test(priority=8,groups={"Regression"},dependsOnMethods= {"checkDemoPageOpened"}) 
	void validateForm_Valid_Detials() throws InterruptedException, IOException {
		
		logger.info("****Starting Testcase Eight entering valid detials in form****");
		
		
		scrollDown(hf.scroll);
		hf.formDetials(ExcelUtility.getData(System.getProperty("user.dir")+"\\testData\\testInputData.xlsx", "Sheet1",6 , 1));
	    boolean status=hf.submitButtonStatus();
	    if(status) {
	    	hf.clickSubmit();
	    	logger.info("****submit button enabled****");
	    	
	    }
	    Assert.assertEquals(hf.getMsg(), getProperties().getProperty("msg"));
	    captureScreen("thankyouMsg");
	    logger.info("***TestCase three excuted successfully***");
	   
	}

}
