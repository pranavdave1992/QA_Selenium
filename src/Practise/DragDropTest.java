package Practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

	public static void main(String[] args) {
		WebDriver fire = new FirefoxDriver();
		fire.get("https://jqueryui.com/droppable/");
		fire.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> frames = fire.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
				
		fire.switchTo().frame(fire.findElement(By.className("demo-frame")));
		WebElement draggable = fire.findElement(By.id("draggable"));
		WebElement droppable = fire.findElement(By.id("droppable"));
	
		Actions build = new Actions(fire);
		build.dragAndDrop(draggable, droppable).build().perform();
		
		String newDrop = droppable.getText();
		
		if(newDrop.equals("Dropped!"))
			System.out.println("Element dropped");
		else
			System.out.println("Element not dropped. Please check again.");
		
	}

}
