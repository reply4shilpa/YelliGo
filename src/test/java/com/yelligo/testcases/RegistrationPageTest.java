package com.yelligo.testcases;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import yelliGo.pages.RegistrationPage;
import yelliGo.pages.TestBase;
import yelliGo.util.TestUtil;
import yelliGo.util.XLS_Reader;

public class RegistrationPageTest extends TestBase {

	RegistrationPage rPage;


	public RegistrationPageTest() {
		super();
		
	}

	@BeforeMethod
	void setup(){
		initialization();
		rPage =new RegistrationPage(driver);	
		
	}
	
	//@Test
		void testMouseHoverSignupLoginBtn() {
			String actualColor = rPage.validateLoginsignupBtnMouseHover();
			String color = "rgba(255, 255, 255, 1)";
			
			Assert.assertEquals(color, actualColor);

		}
	
	@Test
	void testModalWindowcloseBtn() {
		String actualURL= rPage.validateModalWindowCloseBtn();
		String currentUrl = "http://35.165.237.181/yelligo/website/index.html";
		
		Assert.assertEquals(currentUrl, actualURL);

	}
		
		
		
		

	@Test
		void testvalidateLoginSignupBtn()  {
		boolean answer = rPage.validateLoginsignupBtn();
			Assert.assertTrue(answer);
		}
	
	
	@Test
	void testvalidateInfoText() throws InterruptedException  {
		boolean answer = rPage.validateInfoText();
		Assert.assertTrue(answer);
	}
	
	@Test
	void testValidateNextBtn() throws InterruptedException {
			
		String actualstyle= rPage.validateNextBtn();
		System.out.println("actual message is"+actualstyle);
		String style = "display: none;";
		Assert.assertEquals(style,actualstyle);

	}

	 @Test(dataProvider="getRegData" )
	void testRegistration( String CName, String ONum, String gstinno, String address, String fname, String lname, String emailid, String phoneno, String user)  {
		rPage.registration(CName,ONum, gstinno, address, fname, lname, emailid, phoneno, user );
		

	}

	@DataProvider
	public Object [][] getRegData() throws OpenXML4JException
	{
		Object data[][]= TestUtil.getRegTestData("Sheet2");
		return data;
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
 
}
