package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.TestBase;

public class CreateUsersPage extends TestBase{
	
	@FindBy(id="btnAdd")
	WebElement AddButton;
	
	@FindBy(id="systemUser_userType")
	WebElement UserRoleDropDown;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement EmployeeName;
	
	@FindBy(id="systemUser_userName")
	WebElement UserNameField;
	
	@FindBy(id="systemUser_status")
	WebElement StatusDropDown;
	
	@FindBy(id="systemUser_password")
	WebElement UserPassword;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement UserConfirmPassword;
	
	@FindBy(id="btnSave")
	WebElement SaveButton;
	
	//Initializing the Page Objects:

	public CreateUsersPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
