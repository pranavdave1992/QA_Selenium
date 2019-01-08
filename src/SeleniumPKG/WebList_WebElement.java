package SeleniumPKG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebList_WebElement {
	
	public static WebDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		fire.get("https://facebook.com/");
		
		//List all element
		allDivElement();
		
		//List all links in header
		headerLink();
		
		//List all links in footer
		footerLink();
		
		//Close the Browser
		browserClose();
	}
	
	public static void allDivElement(){
		List<WebElement> all = fire.findElements(By.tagName("div"));
			
		System.out.println("Number of Div tags: " + all.size());
		
	}
	
	public static void headerLink(){
		WebElement headerLink = fire.findElement(By.className("loggedout_menubar_container"));
		
		List<WebElement> links = headerLink.findElements(By.tagName("a"));
		System.out.println("Number of links in Header: " + links.size());
		
		//List number of links
		System.out.println("<><><><><>List<><><><><>");
		for(int i=0;i<links.size();i++){
			System.out.println(links.get(i).getText());
		}
		System.out.println("==============================================");
	}
	
	public static void footerLink(){
		WebElement footerlink = fire.findElement(By.id("pageFooter"));
		
		List<WebElement> footerLinks = footerlink.findElements(By.tagName("a"));
		System.out.println("Number of links in Footer: " + footerLinks.size());
		
		System.out.println("<><><><><>List<><><><><>");
		for(int i=0;i<footerLinks.size();i++){
			System.out.println(footerLinks.get(i).getText());
		}
		System.out.println("==============================================");
	}
	
	public static void browserClose() throws InterruptedException {
		//Close the browser
		Thread.sleep(5000);
		fire.close();
	}
	
}
