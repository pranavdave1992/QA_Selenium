package DID;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DIDfetch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		WebDriver fire = new ChromeDriver(); 
		fire.get("https://myaccount.solutions.sip.bell.ca/accounts/login/?next=/");
		fire.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
	
		//int[] orders = {4770,4674,5307,5192,5191,4673,5051,5052,4670,4678,4667,4668,4753,4828,4672,4829,4839,4827,4940,4842,4928,4927,4975,4974,5049,5080,5121,4500,4483,4675,4691,4703,4708,4663,4835,4651,4657,4887,4763,4650,4775,4986,5015,5016,5017,5007,5008,5012,5013,5014,5019,5011,5188,5006,5086,5087,5088,5394,5375,4966,5247,5249,4982,5250,5346,4711,4834,5035,4992,4795};
		//int[] orders={4468,4470,4471,4516,4560,4467,4469,4570,4586,4638,4671,4676,4685,4738,4724,4772,4819,4794,4821,4406,4832,4838,4866,4721,4822,4870,4981,5046,5000,4935,5029,5042,5039,5222,4783,4755,4669,4890,5081,5136,4583,4582,4581,4584,4624,4585,4572,4573,4634,4639,4776,4848,4976,4894,4939,5110,5315,5109,5211,5146,5152,5305,5306,4767,4768,4766,4785,3803,4521,4006,4200,4666,3676,4530,4524,4532,4863,4380,3737,4901,3989,5040,4793,5120,5170,5145,5151,5153,5172,4189,4191,5077,4906,4942,5197,5199,4891,4892};
		int[] orders={4468,4470,4471,4516};
		String orderLink = "https://myaccount.solutions.sip.bell.ca/sales/orders/readonly-view/";
		
		WebElement phoneNumberManagement;
		List<WebElement> TNs;
		
		//List<WebElement> ratecenter;
		
		System.out.println("==============================================");
		
		for(int i=0; i<orders.length;i++){
			fire.get("https://myaccount.solutions.sip.bell.ca/sales/orders/");
			
			Thread.sleep(5000);
			
			WebElement search = fire.findElement(By.xpath(".//*[@placeholder='Search or filter results']"));
			search.sendKeys(""+orders[i]);
			
			Thread.sleep(5000);
			
			WebElement cx = fire.findElement(By.xpath(".//td[@data-title-text='Customer']"));
			String cxName = cx.getText();
						
			fire.get(orderLink + orders[i]);

			phoneNumberManagement = fire.findElement(By.xpath("(.//i[@class='fa pull-right fa-plus-square-o'])[2]"));
			phoneNumberManagement.click();
			TNs = fire.findElements(By.xpath(".//div[@class='form-group ng-scope' and @ng-repeat='idx in formData.localNumberPortability.local_numbers.port']/p"));

			if(TNs.size()==0){
				fire.findElement(By.xpath("(.//i[@class='fa pull-right fa-minus-square-o'])[2]")).click();
				phoneNumberManagement = fire.findElement(By.xpath("(.//i[@class='fa pull-right fa-plus-square-o'])[3]"));
				phoneNumberManagement.click();
				TNs = fire.findElements(By.xpath(".//div[@class='form-group ng-scope' and @ng-repeat='idx in formData.tollFree.numbers.port']/p"));
				 
				if(TNs.size()==0){
					fire.findElement(By.xpath("(.//i[@class='fa pull-right fa-minus-square-o'])[2]")).click();
					phoneNumberManagement = fire.findElement(By.xpath("(.//i[@class='fa pull-right fa-plus-square-o'])[5]"));
					phoneNumberManagement.click();
					
					TNs = fire.findElements(By.xpath(".//div[@class='form-group ng-scope' and @ng-repeat='idx in formData.localNumberPortability.local_numbers.new']/p"));
					if(TNs.size()==0){
						System.out.println(cxName + "\t" + orders[i] + "\tNo Data availalbe");
					}
					else{
						for(WebElement TN : TNs){
							System.out.println(cxName + "\t" + orders[i] + "\t" + TN.getText());
							}
					}
				}
				else{
					for(WebElement TN : TNs){
						System.out.println(cxName + "\t" + orders[i] + "\t" + TN.getText());
						}
					}
				}
				else{
				for(WebElement TN : TNs){
					System.out.println(cxName + "\t" + orders[i] + "\t" + TN.getText());
				}
			}
			
		}
			
	}
}
