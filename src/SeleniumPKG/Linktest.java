package SeleniumPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Linktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver();
		fire.get("https://facebook.com");
		
		System.out.println(fire.findElement(By.linkText("हिन्दी")).getText());
		
	}

}
