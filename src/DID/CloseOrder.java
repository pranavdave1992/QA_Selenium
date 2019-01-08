package DID;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseOrder {

	public static void main(String[] args) throws InterruptedException {
		// Closing completed orders
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		WebDriver fire = new ChromeDriver(); 
		fire.get("https://myaccount.solutions.sip.bell.ca/accounts/login/?next=/");
		fire.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//fire.manage().window().maximize();
		
		WebElement userid = fire.findElement(By.id("id_username"));
		userid.sendKeys("Pranav");
		
		WebElement pass = fire.findElement(By.id("id_password"));
		pass.sendKeys("Pdbportl1!#");
		
		WebElement btn = fire.findElement(By.xpath(".//button[text()='Login']"));
		btn.click();
		
		Thread.sleep(8000);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Verification password:- ");
		String verification = sc.next();
		sc.close();

		WebElement verify = fire.findElement(By.id("id_verification_code"));
		verify.sendKeys(verification);
		
		WebElement subBtn = fire.findElement(By.xpath(".//button[@type='submit']"));
		subBtn.click();
		
		int[] orders={5942,5947,5949,5950,5951,5968};
		
		String orderLink = "https://myaccount.solutions.sip.bell.ca/sales/quotes/confirm-online/";
		
		for(int i=0; i<orders.length;i++){
			fire.get(orderLink + orders[i]);
			fire.findElement(By.xpath("(.//*[@class='formrow']/ol/li)[7]")).click();
			Thread.sleep(2000);
			fire.findElement(By.xpath(".//button[@ng-click='onFinish()']")).click();
			System.out.println(orders[i] + " is closed");
			System.out.println("==============================================");
		}
			
	}
}