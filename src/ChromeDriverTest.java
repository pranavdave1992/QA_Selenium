import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		WebDriver fire = new ChromeDriver(); 
		fire.get("https://google.ca");
		
		WebElement search = fire.findElement(By.xpath(".//*[@title='Search']"));
		search.sendKeys("Canada");
		Thread.sleep(1000);
		
		List<WebElement> suggestList = fire.findElements(By.xpath(".//*[@class='erkvQe']//li"));
		
		System.out.println("Suggestion:- " + suggestList.size());
		
		for(WebElement a : suggestList) {
			System.out.println(a.getText());
		}

	}

}
