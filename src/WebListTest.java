import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebListTest {
	
	static WebDriver dr = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException {
		dr.get("https://www.google.ca");
		
		//Count of all links
		List<WebElement>links = dr.findElements(By.tagName("a"));
		System.out.println("Total Links:- " + links.size());
		System.out.println("==========================================");
		
		// List of all Links in Footer
		footerLink();
		
		//Footer East
		footerEast();
		
		// Close the browser
		closebrowser();		
	
	}
	
	public static void footerLink() {
		WebElement footer = dr.findElement(By.id("fbar"));
		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		System.out.println("Links in footer:- " + footerLinks.size());
		
		for(int i=0;i<footerLinks.size();i++) {
			System.out.println(footerLinks.get(i).getText());
		}
		
		System.out.println("==========================================");
	}
	
	public static void footerEast() {
		WebElement footerEast = dr.findElement(By.id("fbar"));
		List<WebElement> footerET = footerEast.findElements(By.xpath(".//*[@id='fsl']/a"));
		System.out.println("Links in footer East Cornor:- " + footerET.size());
		
		for(int i=0;i<footerET.size();i++) {
			System.out.println(footerET.get(i).getText());
		}
		System.out.println("==========================================");
	}
	
	
	public static void closebrowser() throws InterruptedException {
		Thread.sleep(5000);
		dr.close();
	}

}
