package web.element.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class adpLogin {

	public static void main(String[] args) throws InterruptedException {
			
		WebDriver fire = new FirefoxDriver();
		fire.get("https://workforcenow.adp.com/workforcenow/login.html");

		WebElement userID = fire.findElement(By.id("user_id"));
		WebElement password = fire.findElement(By.id("password"));
		WebElement subBTN = fire.findElement(By.id("subBtn"));
		
		userID.sendKeys("pranav.d");
		password.sendKeys("Ecd#8137");
		Thread.sleep(2000);
		subBTN.click();
				
	}

}
