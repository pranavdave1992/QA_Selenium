package Practise28Nov;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertBox {
	public static void main(String[] args){
		WebDriver fire = new FirefoxDriver();
		
		fire.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		WebElement btn = fire.findElement(By.xpath(".//*[text(])='Confirm Pop up'"));
		btn.click();
		
		Alert ai = fire.switchTo().alert();
		
		ai.getText();
		
		System.out.println(ai.getText());
		
	}
}
