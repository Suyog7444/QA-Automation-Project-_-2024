package com.Qa.Hybrid.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='input-email']")
	private WebElement emailAddressField;
	@FindBy(xpath = "//*[@id='input-password']")
	private WebElement passwordField;
	@FindBy(xpath = "//*[@value='Login']")
	private WebElement clickOnLogin;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement verifyEmailMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void giveEmailAddress(String filledEmail) {
		emailAddressField.sendKeys("");

	}

	public void givePassword(String filledPassword) {
		passwordField.sendKeys("");

	}

	public void clickonLoginbutton() {
		clickOnLogin.click();

	}

	public String eamilMsg() {
		String warnindText = verifyEmailMsg.getText();
		return warnindText;

	}

}
