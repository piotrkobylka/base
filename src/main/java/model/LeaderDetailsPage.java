package model;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaderDetailsPage {

	@FindBy(xpath = "//div[@id='details']/div/ul/div[1]/div/a/span[1]")
	private WebElement leadStatus;

	private WebDriver driver;

	public LeaderDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CheckLeaderStatus(String expectedStatus) {
		assertEquals(expectedStatus, leadStatus.getText());
	}

}
