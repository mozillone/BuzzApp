package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CreateUserPage extends TestBase{
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIMTab; 
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement AddEmployeeButton; 
	
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

	//Initializing the Page Objects:
	
	public CreateUserPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this); 
	}

	

}
