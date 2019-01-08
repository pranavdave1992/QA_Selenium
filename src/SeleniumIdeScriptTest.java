//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class SeleniumIdeScriptTest {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com";
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("pranavdave09@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("Ecd#81");
    driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    //String verificationErrorString = verificationErrors.toString();
  }
}