import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver dr = new FirefoxDriver();
		dr.get("https://facebook.com");	
		dr.findElement(By.name("email")).sendKeys("dsddsdsdsd");
		dr.findElement(By.name("pass")).sendKeys("dsdgfvddasdx");
		dr.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
		
		Thread.sleep(5000);
		dr.close();
	}

}
