package Practise28Nov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopUP {

	public static void main(String[] args) {
		WebDriver fire = new FirefoxDriver();
		fire.get("https://www.microsoft.com/en-ca/p/surface-pro-6/8ZCNC665SLQ5?activetab=pivot%3aoverviewtab");
		fire.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement closer = fire.findElement(By.xpath("(.//*[@class='sfw-dialog']/div)[1]"));
		closer.click();
		
	}

}
