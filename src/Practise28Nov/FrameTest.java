package Practise28Nov;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
	static WebDriver fire = new FirefoxDriver();
	static WebElement draggable;
	static WebElement droppable;
	static WebElement frame1;
	static WebElement nonDroppable;
	
	public static void main(String[] args) throws InterruptedException{
		
		fire.get("https://jqueryui.com/droppable/");
		fire.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		movable();
		System.out.println("=======================================");
		fire.switchTo().defaultContent();
		nonMovable();
	}
	
	public static void movable(){
		List<WebElement> frames = fire.findElements(By.tagName("iframe"));
		System.out.println("Number of frame:- " + frames.size());
		
		//fire.switchTo().frame("demo-frame");
		frame1 = fire.findElement(By.className("demo-frame"));
		fire.switchTo().frame(frame1);
		
		draggable = fire.findElement(By.id("draggable"));
		droppable = fire.findElement(By.id("droppable"));
		
		System.out.println(droppable.getText());
		
		Actions ai = new Actions(fire);
		ai.dragAndDrop(draggable, droppable).build().perform();
		
		if(droppable.getText().equals("Dropped!"))
			System.out.println("Element dropped!"); 
		else
			System.out.println("Element not dropped!");
	}
	
	public static void nonMovable() throws InterruptedException{
		fire.findElement(By.linkText("Accept")).click();
		List<WebElement> frames = fire.findElements(By.tagName("iframe"));
		System.out.println("Number of frame:- " + frames.size());
		
		//fire.switchTo().frame("demo-frame");
		frame1 = fire.findElement(By.className("demo-frame"));
		fire.switchTo().frame(frame1);
		
		draggable = fire.findElement(By.id("draggable"));
		droppable = fire.findElement(By.id("droppable"));
		nonDroppable = fire.findElement(By.id("draggable-nonvalid"));
		
		System.out.println(droppable.getText());
		
		Actions ai = new Actions(fire);
		ai.dragAndDrop(nonDroppable, droppable).build().perform();
		
		if(droppable.getText().equals("Dropped!"))
			System.out.println("Element dropped!"); 
		else
			System.out.println("Element not dropped!");
		
		Thread.sleep(3000);
		
		System.out.println("==========================");
		
		ai.dragAndDrop(draggable, droppable).build().perform();
		
		if(droppable.getText().equals("Dropped!"))
			System.out.println("Element dropped!"); 
		else
			System.out.println("Element not dropped!");
	}
}
