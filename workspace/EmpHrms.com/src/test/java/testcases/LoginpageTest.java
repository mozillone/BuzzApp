package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import junit.framework.Assert;

public class LoginpageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginpageTest() throws FileNotFoundException {
		super(); 
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException{
		initialization(); 
		loginpage = new LoginPage(); 
			
		
	}
	
	@Test(priority=1)
	public void loginpageTitleTest(){
		String title = loginpage.ValidateLoginPagetitle();  
		Assert.assertEquals(title, "OrangeHRM"); 
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.ValidateHrmsLogo(); 
		Assert.assertTrue(flag);  
	}
	
	@Test(priority=3)
	public void loginPageTest() throws FileNotFoundException, InterruptedException{
		
		homepage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		
		Thread.sleep(10000l); 
		Assert.assertTrue(driver.getPageSource().contains("Dashboard")); 
		//Assert.assertTrue(driver.findElement(By.id("menu_admin_viewAdminModule")));
	}
	
	@AfterMethod
	public void close(){
		driver.quit(); 
	}

}
