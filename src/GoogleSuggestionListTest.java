import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSuggestionListTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver(); 
		fire.get("https://google.ca");
		
		WebElement search = fire.findElement(By.xpath(".//*[@title='Search']"));
		search.sendKeys("Canada");
		Thread.sleep(1000);
		
		List<WebElement> suggestList = fire.findElements(By.xpath(".//*[@class='erkvQe']//li"));
		
		System.out.println("Suggestion:- " + suggestList.size());
		/*for(int i=0; i<suggestList.size(); i++) {
			System.out.println(suggestList.get(i).getText());
		}*/
		
		for(WebElement a : suggestList) {
			System.out.println(a.getText());
		}
		
	}

}
