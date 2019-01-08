package tests;

import org.testng.annotations.Test;
import pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	
	
  @Test
  public void loginWithIncorrectPassword() throws InterruptedException {
	  lp.enterEmail("pdave1573");
	  lp.enterPassword("ffgffdfdddgfffgfgff");	  
	  Assert.assertEquals("Wrong password. Try again or click Forgot password to reset it.", lp.readPasswordError());
  }
  
  @Test
  public void loginWithIncorrectEmail() throws InterruptedException {
	  lp.enterEmail("pdave2222");
	  Assert.assertEquals("Couldn't find your Google Account", lp.readEmailError());
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  lp.openBrowser();
	  lp.openGmail();
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
  }

}
