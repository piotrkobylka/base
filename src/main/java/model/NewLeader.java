package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewLeader {
	
	

	@FindBy(id = "lead-first-name")
	private WebElement leadFirstName;
	
	@FindBy(id = "lead-last-name")
	private WebElement leadLastName;
	
	@FindBy(id = "lead-company-name")
	private WebElement companyName;
	
	@FindBy(how = How.CSS, using = "button[class*=save]")
	private WebElement saveButton;
	
	private WebDriver driver;
	
	public NewLeader(WebDriver driver) {
	      this.driver = driver;
	      PageFactory.initElements(driver, this);
	}
	
	public LeaderDetails FillNewLeaderForm(String leadFirstName, String leadLastName, String companyName){
		this.leadFirstName.sendKeys(leadFirstName);
		this.leadLastName.sendKeys(leadLastName);
		this.companyName.sendKeys(companyName);
		saveButton.click();
		
		return new LeaderDetails(driver);
	}

}
