import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AttributeTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ebay.com/");
		
		WebElement last = driver.findElement(By.id("gh-ac"));
		
		String value = last.getAttribute("placeholder");
		String max_size = last.getAttribute("maxlength");
		System.out.println(value + "\t" + max_size);
		
		Thread.sleep(10000);
		driver.close();
	}

}
