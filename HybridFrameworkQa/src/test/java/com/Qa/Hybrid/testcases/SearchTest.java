package com.Qa.Hybrid.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Qa.Hybrid.Pages.HomePage;
import com.Qa.Hybrid.Pages.SearchPage;
import com.Qa.Hybrid.base.base;

public class SearchTest extends base {
	public WebDriver driver;
	public HomePage homePage;
	public SearchPage searchPage;

	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = OpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

	@Test(priority = 1)
	public void Verify_searching_with_an_existing_Product_Name() {

		homePage.SearchBoxField(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchOption();
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "valid Product is not dispalyed");
	}

	@Test(priority = 2)
	public void Verify_searching_with_an_Nonexisting_Product_Name() {

		homePage.SearchBoxField(dataprop.getProperty("invalidProduct"));
		homePage.clickOnSearchOption();
		String actualMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualMessage, dataprop.getProperty("NoProductTextInSearchResults"),
				"error msg is not getting");
	}

	@Test(priority = 3)
	public void Verify_searching_with_an_Blank_Product_Name() {

		homePage.clickOnSearchOption();
		String actualMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualMessage, dataprop.getProperty("NoProductTextInSearchResults"),
				"error msg is not getting");

	}
}