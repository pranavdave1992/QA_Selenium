package Practise;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class adpLogin {
	//static WebDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Jars\\chromedriver.exe");
		WebDriver fire = new ChromeDriver();
		
		fire.get("https://workforcenow.adp.com/workforcenow/login.html");
		
		WebElement login = fire.findElement(By.id("user_id"));
		WebElement pass = fire.findElement(By.id("password"));
		Thread.sleep(2000);
		WebElement subBTN = fire.findElement(By.id("subBtn"));
		
		login.sendKeys("pranav.d");
		pass.sendKeys("Ecd#8137");
		subBTN.click();
		fire.manage().logs();
		
		Thread.sleep(5000);
		System.out.println("Execution finished...");
		
		//footerLinks();
		//fire.quit();
	}
	/*
	public static void footerLinks() {
		WebElement links = fire.findElement(By.className("adp-footer"));
		List<WebElement> LinkTAG = links.findElements(By.tagName("a"));
		
		System.out.println("Total Links: " + LinkTAG.size());
		
		int temp = 0;
		
		for(int i=0;i<LinkTAG.size();i++) {
			System.out.println(LinkTAG.get(i).getText());
			
			if(LinkTAG.get(i).getText().equals(""))
				temp++;
		}
		
		System.out.println("Hidden Links:" + temp);
	}*/

}
