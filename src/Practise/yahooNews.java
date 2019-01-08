package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class yahooNews {

	public static WebDriver fire = new FirefoxDriver();
	
	public static void main(String[] args) {

		fire.get("https://ca.yahoo.com/");
		
		fire.findElement(By.linkText("News")).click();
		
		//String expectedTitle = "News & Headlines - Yahoo News Canada";
		//String actualTitle = fire.getTitle();
		
		sponsordNEWS();
		
		//if(expectedTitle.equals(actualTitle)) {
			//System.out.println("Link is redirected to expected page! ");
			//fire.manage().window().maximize();
			topNEWS();
		//}else {
			//System.out.println("Wrong Link...Please check!");
		//}
		
	}
	
	public static void topNEWS() {
		List<WebElement> top = fire.findElements(By.xpath(".//*[@id='YDC-Stream']/ul/li/div/div/div[2]/h3/a"));
		System.out.println(top.size());
		
		for(int i=0; i<top.size();i++) {
			System.out.println(top.get(i).getText());
		}
	}
	
	public static void sponsordNEWS() {
		//WebElement sponsor = fire.findElement(By.xpath(".//*[@id='YDC-Stream']/ul/li[3]/div/div[1]/div/h3/a/u"));
		//System.out.println(sponsor.getText());
		String temp = fire.findElement(By.xpath(".//*[@id='YDC-Stream']/ul/li[3]/div/div[1]/div/h3/a/span")).getText();
		System.out.println(temp);
		
		/*for(int i=0; i<sponsor.size();i++) {
			System.out.println(sponsor.get(i).getText());
		}*/
	
		
		System.out.println("Finished");
		//fire.close();
	}

}
