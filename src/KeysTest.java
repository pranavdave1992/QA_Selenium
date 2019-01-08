import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeysTest {

	public static void main(String[] args) throws InterruptedException {
		// We can automate to enter any keys from keyboard
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		String currentPage = driver.getTitle();
		System.out.println("You are on Page: - " + currentPage);
		
		driver.findElement(By.id("identifierId")).sendKeys("pdave1573");
		driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys("ssdffdfdfd");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);		

	}

}
