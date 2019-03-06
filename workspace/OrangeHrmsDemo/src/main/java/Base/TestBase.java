package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase() throws FileNotFoundException{
		try {
		prop = new Properties();
		
			FileInputStream ip = new FileInputStream("");
		
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		
	}

	public static void initialize(){
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")){
			System.setProperty("","");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("","");
			driver = new FirefoxDriver();
		}
		
	}
}
