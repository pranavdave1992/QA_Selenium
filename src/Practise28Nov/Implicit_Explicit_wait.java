package Practise28Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Implicit_Explicit_wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver();
		fire.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fire.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		WebElement email = fire.findElement(By.xpath(".//*[@type='email']"));
		email.sendKeys("pdave1573");
		email.sendKeys(Keys.ENTER);
		
		WebElement pass = fire.findElement(By.name("password"));
		pass.sendKeys("sdsdasds");
		pass.sendKeys(Keys.ENTER);
		
		WebElement error = fire.findElement(By.xpath(".//*[@class='dEOOab RxsGPe']"));
		System.out.println(error.getText());
	}

}
