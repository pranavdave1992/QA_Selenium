import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementPresentTest {

	public static void main(String[] args) {
		
		WebDriver fire = new FirefoxDriver();
		
		fire.get("https://google.ca");
		
		List<WebElement> element = fire.findElements(By.linkText("Business"));
		
		System.out.println(element.size());
		
		if(element.size()>0)
			System.out.println("Element Present");
		else
			System.out.println("Element not Present");
	}

}
