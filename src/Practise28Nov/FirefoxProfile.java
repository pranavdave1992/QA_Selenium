package Practise28Nov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxProfile {
	public static void main(String[] args){
		ProfilesIni pi = new ProfilesIni();
		WebDriver fire = new FirefoxDriver();
		pi.getProfile("Pranav");
		
		fire.get("https://google.ca");
	}

}
