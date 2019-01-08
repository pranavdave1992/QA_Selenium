package DID;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class StarTelecom {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		WebDriver fire = new FirefoxDriver(); 
		fire.get("https://myaccount.solutions.sip.bell.ca/accounts/login/?next=/");
		fire.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fire.manage().window().maximize();
		
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
	
		fire.get("https://myaccount.solutions.sip.bell.ca/sales/orders/");
		fire.findElement(By.xpath(".//*[@placeholder='Search or filter results']")).sendKeys("StarTelecom_toronto");
		Thread.sleep(5000);
		
		fire.findElement(By.partialLinkText("Pending")).click();
		Thread.sleep(3000);
		
		fire.findElement(By.xpath("(.//*[text()=' 100 '])[1]")).click();
		Thread.sleep(4000);
			
		List<WebElement> orders = fire.findElements(By.xpath(".//*[@sortable='id']"));
		String[] arr = new String[orders.size()]; 
		  
        // ArrayList to Array Conversion 
        for (int i =0; i < orders.size(); i++){ 
            arr[i] = orders.get(i).getText(); 
        }
		
		String orderLink = "https://myaccount.solutions.sip.bell.ca/sales/quotes/confirm-online/";
		
		for(int i=0; i<arr.length; i++){
			System.out.println("======================================");
			System.out.println(arr[i]);
			//System.out.println("URL:" + orderLink + arr[i] + "/#/home/step3");
			fire.get(orderLink+arr[i]+"/#/home/step3");
			
			fire.findElement(By.xpath(".//a[@data-target='#fileLocalDidModal' and @data-toggle='modal']")).click();
			List<WebElement> TN = fire.findElements(By.xpath(".//input[@class='form-control ng-pristine ng-valid' and @ng-model='idx.number' and @name='inbound_number_(idx.fieldReference)']"));
			System.out.println(TN.size());		
				for(WebElement ls : TN){
					System.out.println(ls.getAttribute("value"));
				}
				
			System.out.println("======================================");
			try{
			fire.findElement(By.xpath("(.//button[text()='Save and close'])[2]")).click();
			}
			catch(Throwable t){
			}
			Thread.sleep(2000);
		}
		
	}
}
