package SeleniumPKG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginTest {
	
	public static void main(String args[]){
		gmail();
		ebay();
	}
	
	public static void gmail(){
		//Gmail Login Test
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://accounts.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='identifierId']")).clear();
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("pranavdave09");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Ecd#8137@");
		driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();
	}
	
	public static void ebay(){
		//Ebay Login Test
		FirefoxDriver driver = new FirefoxDriver();
			
		driver.get("https://signin.ebay.ca/");	
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("pranavdave09");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Ecd#8137@");
		driver.findElement(By.xpath("//*[@id='sgnBt']")).click();
	}
}
