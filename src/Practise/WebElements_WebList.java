package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElements_WebList {

	static FirefoxDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fire.get("https://www.businessinsider.com/amazon-movers-and-shakers-best-selling-tech-2018-2#a-wireless-charging-stand-8");
		
		top10();
	}
	
	public static void top10() {
		//WebElement all = fire.findElementByXPath(".//h2[@class='slide-title-text']");
		List<WebElement> all = fire.findElements(By.xpath(".//h2[@class='slide-title-text']"));
		System.out.println(all.size());
		
		for(int i=0;i<all.size();i++) {
			System.out.println(all.get(i).getText());
		}
	}

}
