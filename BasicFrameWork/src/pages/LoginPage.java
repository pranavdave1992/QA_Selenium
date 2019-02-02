package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public void openBrowser() {
		driver = new FirefoxDriver();
	}
	
	public void openGmail() {
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(a);
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@aria-label='Enter your password']")).sendKeys(b);
		driver.findElement(By.xpath(".//*[@aria-label='Enter your password']")).sendKeys(Keys.ENTER);;
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
