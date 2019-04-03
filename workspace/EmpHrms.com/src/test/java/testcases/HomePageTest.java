package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import junit.framework.Assert;

public class UserPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public UserPageTest() throws FileNotFoundException {
		super();
		
		 loginpage = new LoginPage();
		 homepage = new HomePage();
	}

	@BeforeMethod
	public void setup() throws FileNotFoundException{
		initialization();
		loginpage = new LoginPage(); 
		
}
	
	/*@Test(priority=1)
	public void loginPageTest() throws FileNotFoundException{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(driver.getPageSource().contains("Dashboard")); 
		//Assert.assertTrue(driver.findElement(By.id("menu_admin_viewAdminModule")));
	}*/
	
	@Test(priority=1)
	public void verifyCreateUserPage() throws FileNotFoundException{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(driver.getPageSource().contains("Dashboard")); 
		homepage = homepage.ClickonNewUserLink();
		//String title = loginpage.ValidateLoginPagetitle(); 
		//Assert.assertEquals(title, "OrangeHRM");
		
		this.takeSnapShot(driver, "c://test.png") ;   
	}
	
	@AfterClass
	public void close(){
		driver.quit();
	}

}