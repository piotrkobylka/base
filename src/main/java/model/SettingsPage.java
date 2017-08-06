package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	@FindBy(xpath = "//a[@href='/settings/leads']")
	private WebElement leadsLeftLink;

	private WebDriver driver;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SettingsLeadsSubMenu OpenLeadsSubmenu() {
		leadsLeftLink.click();
		return new SettingsLeadsSubMenu(driver);
	}
}
