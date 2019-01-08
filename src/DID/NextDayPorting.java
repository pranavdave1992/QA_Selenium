package DID;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextDayPorting {

	public static void main(String[] args) throws InterruptedException {
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
		
		Xls_Reader xsl = new Xls_Reader("C:\\Next day porting\\Next day list.xlsx");
		int totalRows = xsl.getRowCount("Sheet1");
		
		int[] orders={5941,5946};
		
		String orderLink = "https://myaccount.solutions.sip.bell.ca/sales/quotes/confirm-online/";
		
		for(int i=0; i<orders.length;i++){
			fire.get(orderLink + orders[i]);
			fire.findElement(By.xpath("(.//*[@class='formrow']/ol/li)[3]")).click();
			
			String cx= fire.findElement(By.xpath("(.//div[@class='col-xs-6'])[1]/span")).getText();

			List<WebElement> Numbers = fire.findElements(By.xpath(".//div[@class='form-group ng-scope']/input"));
			System.out.println(orders[i] + "\t" + cx + "\t" + Numbers.size());
						
			//Insertion on the excel sheet
			int k=0;
			while(k<Numbers.size()){
				totalRows++;
				String temp = Numbers.get(k).getAttribute("value");
				xsl.setCellData("Sheet1", "Order", totalRows, orders[i]);
				xsl.setCellData("Sheet1", "Customer", totalRows, cx);
				xsl.setCellData("Sheet1", "TN", totalRows, temp);
				k++;
			}
			
			System.out.println("==============================================");
		}
			
	}
}
