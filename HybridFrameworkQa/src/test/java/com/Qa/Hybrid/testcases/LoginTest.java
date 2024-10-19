package com.Qa.Hybrid.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Qa.Hybrid.Pages.AccountPage;
import com.Qa.Hybrid.Pages.HomePage;
import com.Qa.Hybrid.Pages.LoginPage;
import com.Qa.Hybrid.base.base;
import com.Qa.Hybrid.utiles.Utiles;

public class LoginTest extends base {
	public WebDriver driver;
	public HomePage home;
	public LoginPage loginPage;
	public AccountPage accountPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = OpenApplication(prop.getProperty("browser"));
		home = new HomePage(driver);
		home.clickOnMyAccount();
		home.clickOnLoginOPtion();
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validCredantial")
	public void Verify_logging_into_the_Application_using_valid_credentials(String email, String password)
			 {
	
		loginPage.giveEmailAddress(email);
		loginPage.givePassword(password);
		loginPage.clickonLoginbutton();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayEditYourAccountInformation(),
				"Edit your account information is not dispalyed");

	}

	@DataProvider(name = "validCredantial")
	public Object[][] supplyTestData() {
		Object[][] data = Utiles.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void Verify_logging_into_the_Application_using_invalid_credentials() {
	
		loginPage.giveEmailAddress(Utiles.genreateEmailTimeStamp());
		loginPage.givePassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickonLoginbutton();
		String actualWarningMessage = loginPage.eamilMsg();
		accountPage = new AccountPage(driver);
		String expectedWarningMessage = dataprop.getProperty("expectedWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(actualWarningMessage),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 3)
	public void Verify_logging_into_the_Application_using_invalid_email_address_and_validPassword() {
	
		loginPage.giveEmailAddress(Utiles.genreateEmailTimeStamp());
		loginPage.giveEmailAddress(dataprop.getProperty("password"));
		loginPage.clickonLoginbutton();
		String actualWarningMessage = loginPage.eamilMsg();
		accountPage = new AccountPage(driver);
		String expectedWarningMessage = dataprop.getProperty("expectedWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(actualWarningMessage),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 4)
	public void Verify_logging_into_the_Application_using_valid_email_address_and_invalidPassword()
			throws InterruptedException {
	

		loginPage.giveEmailAddress("email");
		loginPage.givePassword(dataprop.getProperty("invalidpassword"));
		loginPage.clickonLoginbutton();
		String actualWarningMessage = loginPage.eamilMsg();
		accountPage = new AccountPage(driver);
		String expectedWarningMessage = dataprop.getProperty("expectedWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(actualWarningMessage),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 5)
	public void Verify_logging_into_the_Application_using_NO_email_address_and_NOvalidPassword() {
	
		loginPage.clickonLoginbutton();
		String actualWarningMessage = loginPage.eamilMsg();
		accountPage = new AccountPage(driver);
		String expectedWarningMessage = dataprop.getProperty("expectedWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(actualWarningMessage),
				"Expected Warning message is not displayed");

	}

}
