package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import PageObjects.HomePage;
import PageObjects.SurgeriesPage;
import PageObjects.healthWillnessForm;
import PageObjects.specialistPage;
import testBase.Base;
import utilites.ExcelUtility;

public class TC_01 extends Base{
	public HomePage p;
	public specialistPage sp;
	public SurgeriesPage surgeries;
	public healthWillnessForm hf;
	public List<String> doctorDetialsString;
	
	
	@Test (priority=1,groups={"sanity"})
	void checkUrl() throws IOException {
		String title=driver.getTitle();
		Assert.assertEquals(title, getProperties().getProperty("title"));
		captureScreen("HomePage");
		logger.info("****Starting Testcase One sanity testing****");
		logger.info("**Practo Url opended Successfully**");
	}
	
	@Test (priority=2,groups="Regression",dependsOnMethods="checkUrl")
	void checkDoctorDetials() throws IOException, InterruptedException {
		p=new HomePage(driver);
		sp=new specialistPage(driver);
		logger.info("****Starting Testcase two extracting doctor detials****");
		p.enterLocation(getProperties().getProperty("location"));
		Thread.sleep(2000);		
		p.locClick();
		
		p.enterSpecialist(getProperties().getProperty("specialist"));
		Thread.sleep(2000);
		p.enterClick();
		
		sp.dropDownclick(sp.patientStoriesDropdownClick);
		sp.selectDropdown(sp.patientStories);
		Thread.sleep(2000);
		
		sp.dropDownclick(sp.experienceDropdownClick);
		sp.selectDropdown(sp.experience);
		Thread.sleep(2000);
		
		sp.dropDownclick(sp.allFiltersClick);
		sp.selectDropdown(sp.feeDropdown);
		Thread.sleep(2000);
		
		sp.dropDownclick(sp.allFiltersClick);
		sp.selectDropdown(sp.availability);
		Thread.sleep(4000);
		
		sp.dropDownclick(sp.sortByClick);
		sp.selectDropdown(sp.sortBy);		
		
		captureScreen("doctorDetials");
		doctorDetialsString=sp.getString(sp.doctorDetials);
		int listCount=1;
		for(String s:doctorDetialsString) {
			String[] data=convert_String_to_Array(s);
			
				
			ExcelUtility.setData(System.getProperty("user.dir")+"\\testData\\testOutput.xlsx","Sheet1",listCount,data.length,data);
			
			
			
			
			listCount++;
			
		}
		logger.info("First five doctor detials entered succesfully in Excel");
		logger.info("***TestCase one excuted successfully***");
		
		
		
		
		
		
	}

}
