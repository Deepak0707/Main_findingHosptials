package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurgeriesPage extends BasePage {

	public SurgeriesPage(WebDriver driver) {
		super(driver);
		
	}
	//locating surgiers link from home page
	//*[@id="container"]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	WebElement surgriesIcon;
	
	//locating surgiers link 
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	public WebElement surgries;
	
	
	
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div/div/p")
	List<WebElement> listofSurgiers;
	
	//locating popular Surgiers
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/h1")
	public WebElement popularSurgiers;

    public void surgiersClick() {
    	surgriesIcon.click();
    }
    
    public void printSurgiers() {
    	for(WebElement ele:listofSurgiers) {
    		System.out.println(ele.getText());
    	}
    }
}
