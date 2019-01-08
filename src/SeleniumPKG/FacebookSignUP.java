package SeleniumPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookSignUP {

	static WebDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		// This is complete Facebook Sign UP
		fire.get("https://facebook.com");
		//WebElement fName = fire.findElement(By.name("firstname"));
		insertValue();
		
		//Check the errors
		Thread.sleep(5000);
		errorHandler();
		
		//Close the browser
		Thread.sleep(5000);
		closeBrowser();

	}

	public static void insertValue() throws InterruptedException{
		WebElement lName = fire.findElement(By.name("lastname"));
		WebElement email = fire.findElement(By.xpath(".//*[@aria-label='Mobile number or email']"));
		Thread.sleep(2000);
		WebElement reEmail = fire.findElement(By.xpath(".//*[@aria-label='Re-enter email']"));
		//WebElement reEmail = (WebElement) (new WebDriverWait(fire, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@aria-label='Re-enter email']"))));
		WebElement password = fire.findElement(By.name("reg_passwd__"));
		WebElement month = fire.findElement(By.id("month"));
		WebElement day = fire.findElement(By.id("day"));
		WebElement year = fire.findElement(By.id("year"));
		WebElement sex = fire.findElement(By.xpath(".//*[@name='sex' and @value=2]"));
		WebElement btn = fire.findElement(By.name("websubmit"));
		
		lName.sendKeys("Dave");
		email.sendKeys("pranav09@gmail.com");
		reEmail.sendKeys("pranav09@gmail.com");
		password.sendKeys("testPassword");
		month.sendKeys("Mar");
		day.sendKeys("20");
		year.sendKeys("1992");
		sex.click();
		btn.click();
	}
	
	private static void errorHandler(){
		WebElement errors = fire.findElement(By.xpath(".//div[text()='What’s your name?']"));
		
		if (errors.isDisplayed())
			System.out.println("Please provide name!");
		
	}
	
	private static void closeBrowser() throws InterruptedException {
		fire.close();
	}
	
	
}
