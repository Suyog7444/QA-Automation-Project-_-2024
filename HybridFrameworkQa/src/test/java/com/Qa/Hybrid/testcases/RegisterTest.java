package com.Qa.Hybrid.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Qa.Hybrid.Pages.AccountSuccessPage;
import com.Qa.Hybrid.Pages.HomePage;
import com.Qa.Hybrid.Pages.RegisterPage;
import com.Qa.Hybrid.base.base;
import com.Qa.Hybrid.utiles.Utiles;

public class RegisterTest extends base {
	public WebDriver driver;
	public HomePage home;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = OpenApplication(prop.getProperty("browser"));
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		home.clickOnRegisterOption();
		registerPage = new RegisterPage(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void VerifyRegisteringanAccountbyprovidingonlytheMandatoryfields() {

		registerPage.fname(dataprop.getProperty("firstName"));
		registerPage.lname(dataprop.getProperty("LastName"));
		registerPage.emailField(Utiles.genreateEmailTimeStamp());
		registerPage.telePhoneFiled(dataprop.getProperty("telephone"));
		registerPage.passwordField(prop.getProperty("password"));
		registerPage.conpasswordField(prop.getProperty("password"));
		registerPage.checkprivacyPolicyField();
		registerPage.optionyesNewsletter();
		registerPage.clickonContinueButton();
		accountSuccessPage = new AccountSuccessPage(driver);
		String actualHeading = accountSuccessPage.getaccountSuccessPageHeading();
		Assert.assertEquals(actualHeading, dataprop.getProperty("accountSuccessfullyCreatedHeading"),
				"Account is not created");
	}

	@Test(priority = 2)
	public void VerifyRegisteringanAccountbyprovidingonAlltheMandatoryfields() {

		registerPage.fname(dataprop.getProperty("firstName"));
		registerPage.lname(dataprop.getProperty("LastName"));
		registerPage.emailField(Utiles.genreateEmailTimeStamp());
		registerPage.telePhoneFiled(dataprop.getProperty("telephone"));
		registerPage.passwordField(prop.getProperty("password"));
		registerPage.conpasswordField(prop.getProperty("password"));
		registerPage.checkprivacyPolicyField();
		registerPage.optionyesNewsletter();
		registerPage.clickonContinueButton();
		accountSuccessPage = new AccountSuccessPage(driver);
		String actualHeading = accountSuccessPage.getaccountSuccessPageHeading();
		Assert.assertEquals(actualHeading, dataprop.getProperty("accountSuccessfullyCreatedHeading"),
				"Account is not created");
//	

	}

	@Test(priority = 3)
	public void VerifyRegisteringanAccountbyprovidingExistingEmail() {

		registerPage.fname(dataprop.getProperty("firstName"));
		registerPage.lname(dataprop.getProperty("LastName"));
		registerPage.emailField(dataprop.getProperty("validEmail"));
		registerPage.telePhoneFiled(dataprop.getProperty("telephone"));
		registerPage.passwordField(prop.getProperty("password"));
		registerPage.conpasswordField(prop.getProperty("password"));
		registerPage.checkprivacyPolicyField();
		registerPage.optionyesNewsletter();
		registerPage.clickonContinueButton();
		String actualWarning = registerPage.getduplicateEmailAddressWarning();
		Assert.assertTrue(actualWarning.contains(dataprop.getProperty("duplicateEmailWarning")),
				"Warning message is not dispalyed");
	}

	@Test(priority = 4)
	public void withoutfillingAnydeatil() {

		registerPage.clickonContinueButton();

		// 1
		String actualPrivacymsg = registerPage.retrievePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacymsg.contains(dataprop.getProperty("privacyPolicyWarning")),
				"Warning message is not dispalyed");
		// 2
		String actualmas1 = registerPage.retrieveFirstNameWarning();
		Assert.assertEquals(actualmas1, dataprop.getProperty("firstNameWarning"), "Warning message is not dispalyed");
		// 3
		String actualmas2 = registerPage.retrieveLastNameWarning();
		Assert.assertEquals(actualmas2, dataprop.getProperty("lastNameWarning"), "Warning message is not dispalyed");
//       4
		String actualmas3 = registerPage.retrieveEmailWarning();
		Assert.assertEquals(actualmas3, dataprop.getProperty("emailWarning"), "Warning message is not dispalyed");
//		5
		String actualmas4 = registerPage.retrieveTelephoneWarning();
		Assert.assertEquals(actualmas4, dataprop.getProperty("telephoneWarning"), "Warning message is not dispalyed");
//	6
		String actualmas5 = registerPage.retrievePasswordWarning();
		Assert.assertEquals(actualmas5, dataprop.getProperty("passwordWarning"), "Warning message is not dispalyed");

	}
}
