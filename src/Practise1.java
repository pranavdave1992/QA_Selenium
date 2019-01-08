import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Practise1 {

	public static void main(String[] args) throws InterruptedException {

		FirefoxDriver dr = new FirefoxDriver();
		dr.get("https://ebay.ca");
		dr.findElementByLinkText("Electronics").click();
		
		String Pagename = dr.getTitle();
		System.out.println(Pagename);
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.close();
	}

}
