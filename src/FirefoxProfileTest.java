import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfileTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		
		ProfilesIni p1 = new ProfilesIni();
		FirefoxProfile profile = p1.getProfile("Pranav");
		
		WebDriver fire = new FirefoxDriver();
		fire.get("https://flipkart.com");

	}

}
