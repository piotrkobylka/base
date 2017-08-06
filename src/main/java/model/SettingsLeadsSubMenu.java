package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsLeadsSubMenu {

	@FindBy(xpath = "//a[@href='#lead-status']")
	private WebElement statusLink;

	@FindBy(xpath = "//div[@id='lead-status']/div[1]/span[1]/div/div/div/div/span[1]/button")
	private WebElement newEdit;

	@FindBy(xpath = "//div[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input")
	private WebElement inputForNewEdit;

	@FindBy(xpath = "//div[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[3]/div/button")
	private WebElement confirmButtonForNewEdit;

	private WebDriver driver;

	public SettingsLeadsSubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void TopMenuSelect(String menuPosition) {
		if (menuPosition.equals("Lead Statuses"))
			statusLink.click();
		else
			throw new UnsupportedOperationException("Not implemented yet");
	}

	public void ModifyLeadStatus(String statusToModify, String newName) {
		if (statusToModify.equals("New")) {
			newEdit.click();
			inputForNewEdit.clear();
			inputForNewEdit.sendKeys(newName);
			confirmButtonForNewEdit.click();
		} else
			throw new UnsupportedOperationException("Not implemented yet");
	}

}
