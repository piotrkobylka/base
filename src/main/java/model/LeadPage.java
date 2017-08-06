package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	
	@FindBy(id = "leads-new")
	private WebElement addLeader;
	
	@FindBy(linkText = "testName testSecName")
	private WebElement leadButton;
	
	
	private WebDriver driver;

	public LeadPage(WebDriver driver) {
	      this.driver = driver;
	      PageFactory.initElements(driver, this);
	}
	
	public NewLeader CreateLeader() {
		addLeader.click();
		return new NewLeader(driver);
	}
	
	public LeaderDetailsPage SelectLeader(){
		leadButton.click();
		return new LeaderDetailsPage(driver);
	}

}
