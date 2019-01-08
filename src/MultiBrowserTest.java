import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MultiBrowserTest {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		String browser = "firefox"; // Chrome, ie
		
		if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			//System.setProperty("webdriver.InternetExplorerDriver.driver", "C:\\Selenium_Jars\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "C:\\Selenium_Jars\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreZoomSetting", true);
			driver= new InternetExplorerDriver(capabilities); 
		}
		
		driver.get("https://facebook.com");
		driver.findElement(By.name("email")).sendKeys("dsddsdsdsd");
		driver.findElement(By.name("pass")).sendKeys("dsdgfvddasdx");
		driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
		
	}

}
