import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementTest {

	public static void main(String[] args) {
		// This is Web Element Test 
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://facebook.com");
		
		WebElement last = driver.findElement(By.id("email"));
		WebElement loginBTN = driver.findElement(By.xpath("//label[@id='loginbutton']/input"));
		
		last.sendKeys("pranavdave09");
		loginBTN.click();
	}

}
