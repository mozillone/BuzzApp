package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR:
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement UsersTab;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement UsermanagementTab;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/ul/li[1]/a/b")
	WebElement AdminTab;
	
	
	
	//Initializing the Page Objects:

	public HomePage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public HomePage ClickonNewUserLink() throws FileNotFoundException{
		AdminTab.click();
		UsermanagementTab.click();
		Actions action = new Actions(driver);
		action.moveToElement(UsersTab).build().perform();
		UsersTab.click();
		return new HomePage();
		
		
		
		
	}

}
