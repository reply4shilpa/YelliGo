package com.yelligo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import yelliGo.pages.HomePage;
import yelliGo.pages.RegistrationPage;
import yelliGo.pages.TestBase;

public class HomePageTest extends TestBase {

	HomePage home;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	void setup() {
		initialization();
		home = new HomePage(driver);

	}

	@Test
	void testValidateTitle() {

		String actualTitle = home.validateTitle();
		String title = "YelliGo";
		Assert.assertEquals(title, actualTitle);

	}

	@Test
	public void testLogoDisplayed() {
		home = new HomePage(driver);
		boolean b = home.logoPresent();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
