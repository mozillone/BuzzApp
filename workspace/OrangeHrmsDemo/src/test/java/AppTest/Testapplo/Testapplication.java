package AppTest.Testapplo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testapplication {

	public static void main(String[] args) {
		

		 WebDriver driver;
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	        //WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();        
	        driver.get("https://google.com");
	        String title = driver.getTitle();
	        System.out.println(title);      
	        driver.quit();      
	    }
	}