package Practise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {
		// Website :- http://the-internet.herokuapp.com/dropdown
		
		WebDriver fire = new FirefoxDriver();
		fire.get("http://the-internet.herokuapp.com/dropdown");
		
		WebElement drop = fire.findElement(By.id("dropdown"));
		List<WebElement> drops = drop.findElements(By.tagName("option"));
		
		for(WebElement ls : drops) {
			System.out.println(ls.getText());
		}
		
		Select s = new Select(drop);
		s.selectByIndex(1);
		Thread.sleep(3000);
		
		s.selectByValue("1");
		Thread.sleep(3000);
		
		s.selectByVisibleText("Option 2");
		Thread.sleep(3000);
	}

}
