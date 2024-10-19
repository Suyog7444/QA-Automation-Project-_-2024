package com.Qa.Hybrid.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void fname(String fnameText) {
		firstNameField.sendKeys(fnameText);

	}

	public void lname(String lnameText) {
		lastNameField.sendKeys(lnameText);

	}

	public void emailField(String emailFieldText) {
		emailAddressField.sendKeys(emailFieldText);

	}

	public void telePhoneFiled(String telephoneText) {
		telephoneField.sendKeys(telephoneText);

	}

	public void passwordField(String passwordText) {
		passwordField.sendKeys(passwordText);

	}

	public void conpasswordField(String conpasswordText) {
		passwordConfirmField.sendKeys(conpasswordText);

	}

	public void checkprivacyPolicyField() {
		privacyPolicyField.click();

	}

	public void optionyesNewsletter() {
		yesNewsletterOption.click();

	}

	public void clickonContinueButton() {
		continueButton.click();

	}

	public String getduplicateEmailAddressWarning() {
		String duplicateEmailAddressWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailAddressWarningText;

	}

public String retrievePasswordWarning() {
		
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	
	
	public String retrieveTelephoneWarning() {
		
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrieveEmailWarning() {
		
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveLastNameWarning() {
		
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveFirstNameWarning() {
		
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
		
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
		
	}
}
