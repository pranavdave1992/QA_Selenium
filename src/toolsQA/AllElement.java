package toolsQA;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AllElement {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// We are testing all Element available on HTML page
		// URL: http://toolsqa.com/automation-practice-form/
		
		//Browser Seletion
		browserSelection();
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		// Partial Link Test + Backward navigation
		System.out.println("-------------------- Partial Link test metod --------------------");
		partialLink();
		
		// Link Test
		System.out.println("-------------------- Link test metod --------------------");
		linkTest();
		Thread.sleep(50000);
		
		// Input Box
		System.out.println("-------------------- Input Box metod --------------------");
		inputBox();
		
		// Radio Button
		System.out.println("-------------------- Radio Button metod --------------------");
		radioBTN();
		
		// Checkbox Selection
		System.out.println("-------------------- Check Box metod --------------------");
		checkBox();
		
		// Upload Test
		
		// Drop Down Test
		System.out.println("-------------------- Drop Down metod --------------------");
		dropDown();
		
		// Multiple selection Drop Down
		System.out.println("-------------------- Multi Select metod --------------------");
		multiSelect();
		
		// Button Test
		System.out.println("-------------------- Submit button metod --------------------");
		System.out.println("About to click the submit button");
		Thread.sleep(10000);
		buttonClick();
		
		// Quit - it will close all opened tabs opened by Selenium
		//Thread.sleep(70000);
		//driver.quit();
		
		//Frame Test
		System.out.println("-------------------- Frame Test metod --------------------");
		frameTest();
	}
	
public static void browserSelection(){
	System.out.println("Please select the browser you want to run this test");
	System.out.println("1. Chrome");
	System.out.println("2. Firefox");
	
	Scanner scan = new Scanner(System.in);
	
	int browser = scan.nextInt();
		
	if(browser==1){
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		System.out.println("Opening in Google Chrome");
		driver = new ChromeDriver();
	}
	else{
		System.out.println("Opening in Firefox");
		driver = new FirefoxDriver();
	}
	System.out.println();
}

public static void partialLink(){
	WebElement links = driver.findElement(By.partialLinkText("Partial Link"));
	links.click();
	String pageTitle = driver.getTitle();
	String pageURL = driver.getCurrentUrl();
	
	System.out.println("You are on page " + pageTitle + "\nLink: " + pageURL); // Page link does not open a new page hence stays on the same page
	
	System.out.println();
}

public static void linkTest(){
	WebElement links = driver.findElement(By.linkText("Link Test"));
	links.click();
	String pageTitle = driver.getTitle();
	String pageURL = driver.getCurrentUrl();
	
	System.out.println("You are on page " + pageTitle + "\nLink: " + pageURL); // Page link does not open a new page hence stays on the same page
	driver.navigate().back();
	
	System.out.println();
}

public static void inputBox(){
	WebElement firstname =	driver.findElement(By.name("firstname"));
	firstname.sendKeys("Pranav");
	
	WebElement lastname = driver.findElement(By.xpath(".//input[@type='text' and  @name='lastname']"));
	lastname.sendKeys("Dave");
	
	WebElement date = driver.findElement(By.id("datepicker"));
	date.sendKeys("20/03/1992");
	
	System.out.println();
}

public static void radioBTN(){
	List<WebElement> sex = driver.findElements(By.xpath("(.//div[@class='control-group'])[5]/input"));
	
	for(WebElement lings : sex){
		if(lings.getAttribute("value").equals("Male")){
			lings.click();
			System.out.println("Male Selected");
		}
	}
	
	List<WebElement> exp = driver.findElements(By.xpath("(.//div[@class='control-group'])[6]/input"));
	
	for(WebElement myExp : exp){
		if(myExp.getAttribute("value").equals("4")){
			myExp.click();
			System.out.println(myExp.getAttribute("value") + " is selected!");
		}
		
	}
	
	System.out.println();
}

private static void checkBox() {
	driver.findElement(By.xpath(".//input[@value='Automation Tester']")).click();
	System.out.println("Preofession: " + driver.findElement(By.xpath(".//input[@value='Automation Tester']")).getAttribute("value"));
	
	System.out.println("Tools Selected:");
	List<WebElement> tools = driver.findElements(By.xpath(".//*[@name='tool' and @type='checkbox']"));
	for(WebElement tool : tools ){
		tool.click();
		System.out.println(tool.getAttribute("value"));
	}
	
	System.out.println();
}

public static void dropDown(){
	WebElement area = driver.findElement(By.id("continents"));
	Select s = new Select(area);
	s.selectByVisibleText("Europe");
	//Can not print Selected value to console as no value defined on the HTML page 
	
	System.out.println();
}

public static void multiSelect(){
	WebElement commands = driver.findElement(By.id("selenium_commands"));
	Select p = new Select(commands);
	p.selectByVisibleText("Navigation Commands");
	p.selectByVisibleText("Wait Commands");
	
	System.out.println();
}

public static void buttonClick(){
	WebElement btn = driver.findElement(By.id("submit"));
	btn.click();
	System.out.println("Button Clicked");
	
	System.out.println("Result on URL:");
	System.out.println(driver.getCurrentUrl());
}

public static void frameTest(){
	driver.get("https://ca.yahoo.com/?p=us");
	List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	System.out.println("Total frames on the page:- " + frames.size());
	
	
	
	System.out.println();
}

}