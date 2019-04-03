package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import junit.framework.Assert;

public class CreateUserTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	CreateUsersPage createuserpage; 
	HomePageTest homepagetest; 

	public CreateUserTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		
		loginpage = new LoginPage();  
		 homepage = new HomePage(); 
		 createuserpage = new CreateUsersPage();   
		 homepagetest = new HomePageTest(); 
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException{
		initialization(); 
		 
	}
	
	@Test(priority=1)
	public void ValidateCreateUser() throws FileNotFoundException{
		//homepagetest = homepagetest.verifyCreateUserPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
		homepage = homepage.ClickonNewUserLink(); 
		createuserpage = createuserpage.Createuser(); 
		
	}
	

	
	@AfterMethod
	public void close(){
		driver.quit();
	}

	

}
