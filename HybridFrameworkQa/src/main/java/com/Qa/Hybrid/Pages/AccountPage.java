package com.Qa.Hybrid.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement editYourAccoutInfomsg;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean getDisplayEditYourAccountInformation() {
		boolean displaysatus = editYourAccoutInfomsg.isDisplayed();
		return displaysatus;

	}
}
