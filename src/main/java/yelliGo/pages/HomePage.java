package yelliGo.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import yelliGo.util.TestUtil;

public class HomePage extends TestBase {

	//static WebDriver driver=null;
	
	@FindBy(xpath = "//div[@class='navbar-header']//img[1]")
	public static WebElement logo;
	

	public HomePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();

	}
	
	public boolean logoPresent() {
		TestUtil.switchToFrame(); 
		boolean dispLogo = logo.isDisplayed();
		System.out.println("logo displayed " + dispLogo);
		return dispLogo;
	}
	

}
