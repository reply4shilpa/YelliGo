package yelliGo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yelliGo.util.TestUtil;

public class LoginPage extends TestBase{
	// Page Factory - Object Repository

	@FindBy(xpath = "//button[@type='button' and text()='Login / SignUp']")
	@CacheLookup
	public static WebElement loginSignup;
	
	@FindBy(xpath = "//a[contains(text(),'LogIn')]")
	@CacheLookup
	public static WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='emailId']")
	@CacheLookup
	public static WebElement loginId;
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	public static WebElement pwd;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	@CacheLookup
	public static WebElement loginBtn;
	
	@FindBy(xpath = "//span[@id='errorEmailid']")
	@CacheLookup
	public static WebElement errorEmailid;
	
	
	public LoginPage(WebDriver driver)  {
		super();
		PageFactory.initElements(driver, this);
	}
	
	

public String validateBlankLogin() {
	TestUtil.switchToFrame();
	loginSignup.click();
	loginButton.click();
	loginId.clear();
	loginId.sendKeys("");
	pwd.clear();
	pwd.sendKeys("");
	loginBtn.click();
	 String errorEmailidMsg=errorEmailid.getText();
	
	 return errorEmailidMsg;
}

public String validateBlankEmail() {
	TestUtil.switchToFrame();
	loginSignup.click();
	loginButton.click();
	loginId.clear();
	loginId.sendKeys("");
	pwd.clear();
	pwd.sendKeys("12345");
	loginBtn.click();
	 String errorEmailidMsg=errorEmailid.getText();
	
	 return errorEmailidMsg;
}
}