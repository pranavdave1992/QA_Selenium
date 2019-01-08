import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://facebook.com");	
		driver.findElement(By.name("email")).sendKeys("dsddsdsdsd");
		driver.findElement(By.name("pass")).sendKeys("dsdgfvddasdx");
		driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
	}

}
