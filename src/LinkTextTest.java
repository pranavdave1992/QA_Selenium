import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkTextTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver dr = new FirefoxDriver();
		dr.get("https://facebook.com/");
		//dr.findElement(By.linkText("हिन्दी")).click();
		dr.findElement(By.partialLinkText("Career")).click();
		
		String expectedTitle = "Facebook Careers";
		
		Thread.sleep(5000);   // Waits for 5 Seconds
		
		String actualTitle = dr.getTitle();
		
		if(expectedTitle.equals(actualTitle)) 
			System.out.println("Test passed");
		else {
			System.out.println("Test Failed");
			System.out.println(actualTitle);
		}
		
	}

}
