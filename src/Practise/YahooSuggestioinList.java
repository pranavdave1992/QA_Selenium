package Practise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooSuggestioinList {

	public static void main(String[] args) {
		WebDriver fire = new FirefoxDriver();
		fire.get("https://ca.yahoo.com/");
		
		WebElement searchBox = fire.findElement(By.id("uh-search-box"));
		searchBox.sendKeys("India");
		
		List<WebElement> yahooList = fire.findElements(By.className("yui3-aclist-list"));
		
		for(WebElement yList : yahooList) {
			System.out.println(yList.getText());
		}

	}

}
