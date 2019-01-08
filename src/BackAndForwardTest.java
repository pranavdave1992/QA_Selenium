import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BackAndForwardTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver();
		fire.get("https://google.ca");
		
		fire.findElement(By.linkText("Advertising")).click();;
		Thread.sleep(4000);
		System.out.println(fire.getTitle());
		
		fire.navigate().back();
		fire.navigate().back();
		Thread.sleep(4000);
		System.out.println(fire.getTitle());
		
		fire.navigate().forward();
		Thread.sleep(4000);
		System.out.println(fire.getTitle());
	
	}

}
