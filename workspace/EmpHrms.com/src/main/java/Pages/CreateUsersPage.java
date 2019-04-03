package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.TestBase;

public class CreateUsersPage extends TestBase{
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement AddButton;
	
	@FindBy(id="systemUser_userType")
	WebElement UserRoleDropDown;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement EmployeeName;
	
	//Initializing the Page Objects:

	public CreateUsersPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}