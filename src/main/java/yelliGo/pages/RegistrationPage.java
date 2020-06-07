package yelliGo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yelliGo.util.TestUtil;

public class RegistrationPage extends TestBase {

	// Page Factory - Object Repository
	// Tried other locators but only xpath worked
	@FindBy(xpath = "//button[@type='button' and text()='Login / SignUp']")
	@CacheLookup
	public static WebElement loginSignup;

	@FindBy(xpath = "//a[@type='button'  and text()='SignUp']")
	@CacheLookup
	static WebElement signUp;

	@FindBy(xpath = "//div[@id='myModal']//button[@class='close'][contains(text(),'×')]")
	static WebElement modalBtn;

	@FindBy(xpath = "//div[@class='reg-txt']")
	static WebElement infoText;

	@FindBy(xpath = "//input[@id='CName']")
	static WebElement companyName;
	
	@FindBy(xpath = "//span[@id='Company-Name']")
	static WebElement msgCompanyName;

	@FindBy(xpath = "//input[@id='OfficeNum']")
	static WebElement companyNum;

	@FindBy(xpath = "//input[@id='GSTIN']")
	static WebElement gstin;

	@FindBy(xpath = " //input[@id='UAddress']")
	static WebElement uAddress;

	@FindBy(xpath = "//button[@id='nextBtn']")
	@CacheLookup
	static WebElement nextBtn;

	@FindBy(xpath = "//input[@id='Owner_FName']")
	static WebElement fName;

	@FindBy(xpath = "//input[@id='Owner_LName']")
	static WebElement lName;

	@FindBy(xpath = "//input[@id='Owner_Email']")
	static WebElement email;

	@FindBy(xpath = "//input[@id='Owner_Phone']")
	static WebElement phone;

	@FindBy(xpath = "//button[@id='nextBtn']")
	@CacheLookup
	static WebElement nextBtn2;

	@FindBy(xpath = "//input[@id='Total_No_User']")
	static WebElement users;

	@FindBy(xpath = "//span[@class='checkmark']")
	static WebElement terms;

	@FindBy(xpath = "//button[@id='prevBtn']")
	@CacheLookup
	static WebElement prevBtn;

	@FindBy(xpath = " //a[@id='Reg_submitForm']")
	@CacheLookup
	static WebElement submit;
	
	@FindBy(xpath = " //span[@id='Company-Name']")
	@CacheLookup
	static WebElement errorMsg;
	

	public RegistrationPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}


	// to check Login/Signup button exist and clickable
	public boolean validateLoginsignupBtn() {

		TestUtil.switchToFrame();
		boolean enable = loginSignup.isEnabled();
		return enable;
	}

	// to check Login/Signup btn mouse hover test to check text color change
	public String validateLoginsignupBtnMouseHover() {

		TestUtil.switchToFrame();
		Actions action = new Actions(driver);
		action.moveToElement(loginSignup).build().perform();
		String color = loginSignup.getCssValue("color");
		return color;
		
	}

	// to check modal window [X]button works or not
	public String validateModalWindowCloseBtn() {

		TestUtil.switchToFrame();
		loginSignup.click();
		modalBtn.click();
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	// to check "New to Yelligo" text
	public boolean validateInfoText() throws InterruptedException  {

		TestUtil.switchToFrame();
		loginSignup.click();
		Thread.sleep(500);
		boolean display = infoText.isDisplayed();
		return display;
	}
	
	
	//validate next button test
	
	public  String validateNextBtn() {
		TestUtil.switchToFrame();
		loginSignup.click();
		signUp.click();
		companyName.sendKeys(" ");
		//companyNum.sendKeys("1234567890");
		//gstin.sendKeys(" ");
		//uAddress.sendKeys("address");
		nextBtn.click();
		String msg=msgCompanyName.getAttribute("style");
		return msg;
	}

	public void registration(String CName, String ONum, String gstinno, String address, String fname, String lname,
			String emailid, String phoneno, String user) {
		TestUtil.switchToFrame();
		loginSignup.click();
		signUp.click();
		companyName.sendKeys(CName);
		companyNum.sendKeys(ONum);
		gstin.sendKeys(gstinno);
		uAddress.sendKeys(address);
		nextBtn.click();
		fName.sendKeys(fname);
		lName.sendKeys(lname);
		email.sendKeys(emailid);
		phone.sendKeys(phoneno);
		nextBtn2.click();
		users.sendKeys(user);
		terms.click();
		//prevBtn.click();
		submit.click();
				

	}

}
