import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLoginTest {

	public static void main(String[] args) throws InterruptedException {
		// This is Gmail Login Test
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		String currentPage = driver.getTitle();
		System.out.println("You are on Page: - " + currentPage);
		
		driver.findElement(By.id("identifierId")).sendKeys("pdave1573");
		
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys("ssdffdfdfd");
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		
		Thread.sleep(3000);
		
		String actualErrMsg = driver.findElement(By.xpath(".//div[@class='dEOOab RxsGPe']")).getText();
		String expectedErrMsg = "Wrong password. Try again or click Forgot password to reset it.";
		
		if(actualErrMsg.equals(expectedErrMsg))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed. Actual error message: " + expectedErrMsg);
		
		// Close the browser automatically
		Thread.sleep(10000);
		driver.close();
		
	}
}
