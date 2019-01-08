package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramePractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver fire = new FirefoxDriver();
		fire.get("http://toolsqa.com/iframe-practice-page/");
		
		List<WebElement> iframeElements = fire.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		fire.switchTo().frame("IF1");
		List<WebElement> partialLinks = fire.findElements(By.linkText("Partial Link Test"));
		System.out.println("Matching Links on frame1:- " + partialLinks.size());
		
		fire.switchTo().defaultContent();
		
		fire.switchTo().frame("iframe2");
		partialLinks = fire.findElements(By.partialLinkText("Hello world!"));
		System.out.println("Matching Links on frame2:- " + partialLinks.size());
		
	}

}
