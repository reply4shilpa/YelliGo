package com.yelligo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import yelliGo.pages.LoginPage;
import yelliGo.pages.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage lPage;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lPage= new LoginPage(driver);
		
		
	}
	@Test
	public void testValidateBlankLogin() {
	String errorMsg=lPage.validateBlankLogin();
	String actualMsg="Please enter your email id";
	Assert.assertEquals(errorMsg, actualMsg);	
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
 
}
