package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithExcel {
	
	public WebDriver driver;
	public Logs log = null;
	/* We can not use below as driver will be null. Remember this code runs as soon as we create an object
	public WebElement email = driver.findElement(By.xpath(".//*[@id='identifierId']"));
	public WebElement emailNextBTN = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
	public WebElement password = driver.findElement(By.xpath(".//*[@aria-label='Enter your password']"));
	public WebElement passwordNextBTN = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
	*/
	
	@FindBy(xpath = ".//*[@id='identifierId']")
	public static WebElement email;
	
	@FindBy(xpath = ".//*[@id='identifierNext']/content/span")
	public static WebElement emailNextBTN;
	
	@FindBy(xpath = ".//*[@aria-label='Enter your password']")
	public static WebElement password; 
	
	@FindBy(xpath = ".//*[@id='passwordNext']/content/span")
	public static WebElement passwordNextBTN;
	
	public void openBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\testing\\prop.properties");
		Properties prop = new Properties(); 
		prop.load(fs);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("firefox")) {
			System.out.println("Opening " + browser);
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			System.out.println("Opening " + browser);
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		
		// We have to mention below line after browser is initiated
		PageFactory.initElements(driver, this);
	}
	
	public void openGmail() {
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log = driver.manage().logs();
	}
	
	public void closeBrowser() {
		System.out.println(log);
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		email.sendKeys(a);
		emailNextBTN.click();
		Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException {
		password.sendKeys(b);
		passwordNextBTN.click();
		Thread.sleep(3000);
	}
	
	public String readEmailError() {
		String actualErr = driver.findElement(By.xpath(".//div[@class='GQ8Pzc']")).getText();
		//System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordError() {
		String actualErr = driver.findElement(By.xpath(".//div[@class='GQ8Pzc']")).getText();
		//System.out.println(actualErr);
		return actualErr;
	}
}
