import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("sdsdsdsdsdfdfdfdfsdfdsfsdas");
		driver.findElement(By.id("pass")).sendKeys("sdsdsdsdsdsdsagffdfse");
		driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
	}

}
