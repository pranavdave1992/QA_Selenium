import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownListTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver fire = new FirefoxDriver();
		
		fire.get("https://ebay.com");
		
		WebElement dropList = fire.findElement(By.xpath(".//*[@id='gh-cat']"));
		List<WebElement> dropList2 = dropList.findElements(By.tagName("option"));
		System.out.println("Total Categories: " + dropList2.size());
		
		for(WebElement a : dropList2) {
			System.out.println(a.getText() + "----------->" + a.isSelected());
			
		}
		
/*		dropList.sendKeys("Books");
		System.out.println("========================After Selection========================");
		for(WebElement a : dropList2) {
			System.out.println(a.getText() + "----------->" + a.isSelected());
		}*/
		
		dropList.sendKeys("Baby");
		System.out.println("========================Selected========================");
		for(WebElement a : dropList2) {
			if(a.isSelected())
				System.out.println(a.getText());
		}
		
		Select s = new Select(dropList);
		s.selectByIndex(8);
		Thread.sleep(3000);
		s.selectByValue("625");
		Thread.sleep(3000);
		s.selectByVisibleText("Baby");
	
	}

}
