import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacbookSignupTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver fire = new FirefoxDriver();
		
		fire.get("https://facebook.com/");
		fire.findElement(By.name("lastname")).sendKeys("Dave");
		fire.findElement(By.xpath("//input[contains(@name, 'reg_email__')]")).sendKeys("98887771234");
		fire.findElement(By.name("reg_passwd__")).sendKeys("IamPassword");
		
		WebElement month = fire.findElement(By.id("month"));
		WebElement day = fire.findElement(By.id("day"));
		WebElement year = fire.findElement(By.id("year"));
	
		Select s = new Select(month);
		s.selectByValue("10");
		
		Select s1 = new Select(day);
		s1.selectByIndex(5);
		
		Select s2 = new Select(year);
		s2.selectByVisibleText("1995");
			
		//fire.findElement(By.xpath("//button[text()='Sign Up']")).click();
		fire.findElement(By.xpath("//button[text()='Sign Up']")).click();
				
		Thread.sleep(3000);
		String expectedErrMsg = "What’s your name?";
		String actualErrMsg = fire.findElement(By.xpath(".//div[@class='_5633 _5634 _53ij']")).getText();
		
		if(actualErrMsg.equals(expectedErrMsg))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed. Error Msg:- " + actualErrMsg);
		
		//fire.findElement(By.className("_5633 _5634 _53ij")).getText(); not valid as class name has space. It can be used in Xpath:- String actualErrMsg = fire.findElement(By.xpath(".//div[@class='_5633 _5634 _53ij']")).getText();
		
		//Closing Firefox
		Thread.sleep(10000);
		fire.close();
	}

}
