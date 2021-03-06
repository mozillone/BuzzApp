package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateRolePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.CreateUserPage;
import junit.framework.Assert;

public class CreateRoleTest extends TestBase{
	
	LoginPage loginpage; 
	HomePage homepage; 
	CreateRolePage createrolepage; 
	CreateUserPage createuserpage; 
//	HomePageTest homepagetest; 

	public CreateRoleTest() throws FileNotFoundException {
		super(); 
		// TODO Auto-generated constructor stub
		
		//loginpage = new LoginPage();  
		// homepage = new HomePage(); 
		 createrolepage = new CreateRolePage(); 
		 createuserpage = new CreateUserPage(); 
		// homepagetest = new HomePageTest(); 
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException{
		initialization(); 
		loginpage = new LoginPage();  
		homepage = new HomePage(); 
		 
	}
	
	@Test(priority=1)
	public void ValidateCreateUser() throws FileNotFoundException, InterruptedException{
		//homepagetest = homepagetest.verifyCreateUserPage();
		Thread.sleep(1000l); 
		homepage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		Thread.sleep(1000l); 
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));  
		homepage = homepage.ClickonNewUserLink(); 
		//createuserpage = createuserpage.Createuser();
		createrolepage = createrolepage.Createrole(); 
		
		
	}
	

	
	@AfterMethod
	public void close(){
		driver.quit(); 
	}

	

}
