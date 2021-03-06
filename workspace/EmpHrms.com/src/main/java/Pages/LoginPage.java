package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	
	@FindBy(id="txtUsername")
	WebElement Username;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	@FindBy(id="btnLogin")
	WebElement LoginButton;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div/img")
	WebElement HrmsLogo;
	
	//Initializing the Page Objects:

	public LoginPage() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String ValidateLoginPagetitle(){
		return driver.getTitle(); 
		
	}
	
	
	public boolean ValidateHrmsLogo(){
		return HrmsLogo.isDisplayed(); 
		
	}
	
	public HomePage login(String username, String password) throws FileNotFoundException{
		Username.sendKeys(username);
		Password.sendKeys(password);
		
		LoginButton.click();
		
		return new HomePage();
	}

}
