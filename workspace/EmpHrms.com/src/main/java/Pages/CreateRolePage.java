package Pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class CreateRolePage extends TestBase{
	
	//Page Factory - OR:
	
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
	
	@FindBy(id="search_form")
	WebElement SearchButton;
	
	//Initializing the Page Objects:

	public CreateRolePage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public CreateRolePage Createrole() throws FileNotFoundException, InterruptedException{
		Thread.sleep(1000l);
		
		//SearchButton.click();
		System.out.println("Hai How are you");
		
		WebElement element = driver.findElement(By.id("btnAdd"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		//AddButton.click();
		
		WebElement select = driver.findElement(By.id("frmSystemUser"));
		List<WebElement> allOptions = select.findElements(By.id("systemUser_userType"));
		for (WebElement option : allOptions) {
		    System.out.println(String.format("ESS", option.getAttribute("value")));
		   Thread.sleep(1000l);
		    option.click();
		}
		
		List<WebElement> allOptions1 = select.findElements(By.id("systemUser_employeeName_empName"));
		for (WebElement option : allOptions1) {
		    System.out.println(String.format("ESS", option.getAttribute("value")));
		   Thread.sleep(1000l);
		   option.sendKeys("Bhuvan");
		    //option.click();
		}
		
		//Select Role = new Select(UserRoleDropDown);
		//Role.selectByVisibleText("ESS");
		EmployeeName.sendKeys("Bhuvan");
		UserNameField.sendKeys("QualityAnalyst");
		
		Select Status = new Select(UserRoleDropDown);
		Status.selectByVisibleText("Enabled");
		
		UserPassword.sendKeys("Password@123");
		UserConfirmPassword.sendKeys("Password@123");
		SaveButton.click();
		
		
		return new CreateRolePage();
		
	}

}
