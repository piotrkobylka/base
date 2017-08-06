package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TopMenu {

	@FindBy(id = "nav-leads")
	private WebElement leadBtn;

	@FindBy(how = How.CSS, using = "i[class*=base-icon-arrow-down]")
	private WebElement userSettingsButton;

	private WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LeadPage OpenLeadPage() {
		leadBtn.click();
		return new LeadPage(driver);
	}

	public UserSettingsMenu OpenUserSettings() {
		userSettingsButton.click();
		return new UserSettingsMenu(driver);
	}
}
