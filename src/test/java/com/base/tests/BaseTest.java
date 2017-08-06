package com.base.tests;

import org.openqa.selenium.chrome.ChromeDriver;

import model.LeadPage;
import model.LeaderDetails;
import model.LeaderDetailsPage;
import model.LoginPage;
import model.MainPage;
import model.NewLeader;
import model.SettingsLeadsSubMenu;
import model.SettingsPage;
import model.UserSettingsMenu;

import org.junit.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	private ChromeDriver driver;

	// Set up section - lets provide your personal data for testing account
	private static final String name = "ENTER_YOUR_TEST_BASE_LOGIN_HERE";
	private static final String password = "ENTER_YOUR_TEST_BASE_PASSWORD_HERE";
	private static final String BASE_URL = "https://core.futuresimple.com/users/login";
	
	@Before
	public void setUp() {

		File pathToDriver = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", pathToDriver.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testBaseLeader() {

		final String newLeadName = "testName";
		final String newLeadSecondName = "testSecName";
		final String newLeadCompany = "testCompany";
		final String expectedStateSpanText = "New";
		final String menuPosition = "Lead Statuses";
		final String statusToModifyName = "New";
		final String newNameForStatus = "NewName";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.Open(BASE_URL);
		MainPage mainPage = loginPage.Login(name, password);
		LeadPage leadPage = mainPage.OpenLeadPage();
		NewLeader leader = leadPage.CreateLeader();
		LeaderDetails leaderDetails = leader.FillNewLeaderForm(newLeadName, newLeadSecondName, newLeadCompany);
		leaderDetails.CheckLeaderState(expectedStateSpanText);
		UserSettingsMenu userSettingsMenu = mainPage.OpenUserSettingsMenu();
		SettingsPage settingsPage = userSettingsMenu.ClickSettingsMenu();
		SettingsLeadsSubMenu leadsSubmenu = settingsPage.OpenLeadsSubmenu();
		leadsSubmenu.TopMenuSelect(menuPosition);
		leadsSubmenu.ModifyLeadStatus(statusToModifyName, newNameForStatus);
		leadPage = mainPage.OpenLeadPage();
		LeaderDetailsPage leaderDetailsPage = leadPage.SelectLeader();
		leaderDetailsPage.CheckLeaderStatus(newNameForStatus);

		//Optionally - wait after some step to see results. Lets leave it for future ;)
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
