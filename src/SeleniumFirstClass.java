import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumFirstClass {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("asfdfdsdsedsdffd");
		driver.findElement(By.id("pass")).sendKeys("sdasdasdasdsdesda");
		driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
	}
}