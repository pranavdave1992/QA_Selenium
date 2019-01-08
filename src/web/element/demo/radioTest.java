package web.element.demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class radioTest {

	public static void main(String[] args) {
		// Radio Button Selection
		WebDriver fire = new FirefoxDriver();
		
		fire.get("https://facebook.com");
		//WebElement radio = fire.findElement(By.className("mtm _5wa2 _5dbb"));
		WebElement temp = fire.findElement(By.xpath(".//div[@class='mtm _5wa2 _5dbb']"));
		List<WebElement> sex = temp.findElements(By.className("_58mt"));
				
		//System.out.println(a);
		System.out.println("Number of radio button: " + sex.size());
		
		for(int i=0;i<sex.size();i++){
			if(sex.get(i).getText().equals("Male")){
				sex.get(i).click();
				System.out.println("Male selected");
			}
		}
	}

}
