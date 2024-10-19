package com.Qa.Hybrid.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropDown;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement LoginPageOptions;
	@FindBy(xpath = "//*[text()='Register']")
	private WebElement registerOption;
	@FindBy(name = "search")
	private WebElement searchBoxField;
	@FindBy(xpath = "//*[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMyAccount() {
		myAccountDropDown.click();

	}

	public void clickOnLoginOPtion() {

		LoginPageOptions.click();

	}

	public void clickOnRegisterOption() {
		registerOption.click();

	}

	public void SearchBoxField(String TypeSearchItems) {
		searchBoxField.sendKeys(TypeSearchItems);

	}

	public void clickOnSearchOption() {
		searchButton.click();
	}

}
