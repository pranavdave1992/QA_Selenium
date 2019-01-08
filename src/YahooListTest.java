import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver fire = new FirefoxDriver();
		
		fire.get("https://ca.yahoo.com/");
		List<WebElement> trending = fire.findElements(By.xpath(".//li[@data-category='trending news']/ul/li/a"));
		System.out.println(trending.size());
		
		for(int i=0;i<trending.size();i++) {
			System.out.println(trending.get(i).getText());
		}
		
		System.out.println("=============================");
		for(WebElement a : trending){
			System.out.println(a.getText());
		}
		
	}

}
