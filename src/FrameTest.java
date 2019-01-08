import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameTest {

	public static void main(String[] args) {
		// Droppable Test
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		
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
		
		System.out.println("---------------------After Switch---------------------");
		//driver.switchTo().frame(0); // This is the frame index or ith frame on the page 
		//driver.switchTo().frame(arg0); // Only works with id attribute on iframe tag
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // This applies with iframe class
		//driver.switchTo().parentFrame(); // To move to parent iframe
		
		result = driver.findElements(By.linkText("Sortable"));
		
		System.out.println(result.size());
		
		if(result.size()>0)
			System.out.println("Sortable is on the page");
		else
			System.out.println("Sortable is not on the page");
		
		dragBox = driver.findElements(By.id("draggable"));
		System.out.println(dragBox.size());
		
		if(dragBox.size()>0)
			System.out.println("Draggable displayed");
		else
			System.out.println("Draggable not displayed");
		
		System.out.println("---------------------After Switch to Main---------------------");
		driver.switchTo().defaultContent(); // Switching to main page 
		
		result = driver.findElements(By.linkText("Sortable"));
		
		System.out.println(result.size());
		
		if(result.size()>0)
			System.out.println("Sortable is on the page");
		else
			System.out.println("Sortable is not on the page");
		
		dragBox = driver.findElements(By.id("draggable"));
		System.out.println(dragBox.size());
		
		if(dragBox.size()>0)
			System.out.println("Draggable displayed");
		else
			System.out.println("Draggable not displayed");
		
	}

}
