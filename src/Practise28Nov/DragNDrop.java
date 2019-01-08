package Practise28Nov;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver();
		fire.get("https://jqueryui.com/droppable/");
		
		List<WebElement> frames = fire.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		fire.switchTo().frame(0);
		WebElement draggable = fire.findElement(By.id("draggable"));
		WebElement droppable = fire.findElement(By.id("droppable"));
		
		Actions ai = new Actions(fire);
		ai.dragAndDrop(draggable, droppable);
		ai.build().perform();
		
		if(droppable.getText().equals("Dropped!"))
			System.out.println("Element dropped!");
	}

}
