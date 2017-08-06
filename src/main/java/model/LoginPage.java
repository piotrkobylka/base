package model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	@FindBy(id = "user_email")
	private WebElement email;

	@FindBy(id = "user_password")
	private WebElement password;

	@FindBy(how = How.CSS, using = ".controls i")
	private WebElement loginBtn;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public LoginPage Open(String urlToLogin) {
		driver.get(urlToLogin);
		return this;

	}

	public MainPage Login(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		loginBtn.click();
		return new MainPage(driver);
	}

}
