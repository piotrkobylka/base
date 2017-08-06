package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSettingsMenu {

	@FindBy(xpath = "//a[@href='/settings/profile']")
	private WebElement settingsLink;

	private WebDriver driver;

	public UserSettingsMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SettingsPage ClickSettingsMenu() {
		settingsLink.click();
		return new SettingsPage(driver);
	}
}
