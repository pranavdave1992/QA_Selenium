package Practise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ebayLinks {
	static WebDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) {
		fire.get("https://www.ebay.ca/");
		
		//find all links
		//WebElement lks = fire.findElement(By.id("gh"));
		List<WebElement> allLinks = fire.findElements(By.tagName("a"));
		System.out.println("We are on page:- " + fire.getTitle());
		System.out.println(fire.getCurrentUrl());
		System.out.println("Total links on the page:- " + allLinks.size());
		
		//for(int i=0;i<allLinks.size();i++) {
		//	System.out.println(allLinks.get(i).getText());
		//}
		
		//find header Links
		headerLink();
		
		//List and count footerLinks
		//footerLink();
		
		//close the Browser
		//fire.quit();
	}
	
	public static void headerLink() {
		System.out.println("====================================================================================");
		WebElement lks = fire.findElement(By.id("gh"));
		List<WebElement> links = lks.findElements(By.tagName("a"));
		System.out.println("Header Link: " + links.size());
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
		
		System.out.println("====================================================================================");
	}

	public static void footerLink() {
		System.out.println("====================================================================================");
		WebElement footArea = fire.findElement(By.id("glbfooter"));
		List<WebElement> fLinks = footArea.findElements(By.tagName("a"));
		
		System.out.println("Number of links in footer:- " + fLinks.size());
		
		for(int i=0;i<fLinks.size();i++) {
			System.out.println(fLinks.get(i).getText());
		}
		System.out.println("====================================================================================");
	}

}
