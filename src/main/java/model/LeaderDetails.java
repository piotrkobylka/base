package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class LeaderDetails {
	
	@FindBy(how = How.CSS, using = "span[class*=lead-status]")
	private WebElement stateSpan;
	
private WebDriver driver;
	
	public LeaderDetails(WebDriver driver) {
	      this.driver = driver;
	      PageFactory.initElements(driver, this);
	}
	
	public void CheckLeaderState(String stateSpanText){
		assertEquals(stateSpanText, stateSpan.getText());
	}

}
