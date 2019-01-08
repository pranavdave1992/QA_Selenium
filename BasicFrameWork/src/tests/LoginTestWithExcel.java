package tests;

import org.testng.annotations.Test;
import pages.*;
import data.Data;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestWithExcel {
	
	LoginPageWithExcel lp = new LoginPageWithExcel();
	Data d = new Data();
	
  @Test
  public void loginWithIncorrectPassword() throws InterruptedException {
	  //System.out.println(xsl.getCellData("Data1", "UserName", 3));
	  lp.enterEmail(d.validEmail);
	  lp.enterPassword(d.wrongPassword);	  
	  Assert.assertEquals(d.expectedErr, lp.readPasswordError());
  }
  
  @Test
  public void loginWithIncorrectEmail() throws InterruptedException {
	  lp.enterEmail(d.invalidEmail);
	  Assert.assertEquals(d.invalidEmailErr, lp.readEmailError());
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openGmail();
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
  }

}
