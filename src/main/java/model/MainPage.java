package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LeadPage OpenLeadPage() {
		return new TopMenu(driver).OpenLeadPage();
	}

	public UserSettingsMenu OpenUserSettingsMenu() {
		return new TopMenu(driver).OpenUserSettings();
	}
}
