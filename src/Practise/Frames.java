package Practise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frames {

	static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) {
		// Droppable Test
		
		
		driver.get("https://jqueryui.com/droppable/");
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
	
		switching();		
		
		System.out.println("---------------------After Switch---------------------");
		//driver.switchTo().frame(0); // This is the frame index or ith frame on the page 
		//driver.switchTo().frame(arg0); // Only works with Name or id attribute on iframe tag
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // This applies with iframe class
		//driver.switchTo().parentFrame(); // To move to parent iframe
		switching();
				
		System.out.println("---------------------After Switch to Main---------------------");
		driver.switchTo().defaultContent(); // Switching to main page 
		
		switching();
	}
	
	public static void switching(){
		List<WebElement> result = driver.findElements(By.linkText("Sortable"));
		
		System.out.println(result.size());
		
		if(result.size()>0)
			System.out.println("Sortable is on the page");
		else
			System.out.println("Sortable is not on the page");
		
		List<WebElement> dragBox = driver.findElements(By.id("draggable"));
		
		System.out.println(dragBox.size());
		
		if(dragBox.size()>0)
			System.out.println("Draggable displayed");
		else
			System.out.println("Draggable not displayed");
		
	}

}
