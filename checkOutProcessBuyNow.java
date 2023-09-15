package com.providio.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;

public class checkOutProcessBuyNow extends baseClass{
	
	public void buynow() throws InterruptedException {
		
	 Thread.sleep(3000);
		
	   clickContinueAsGuest();
        
      checkOutPage cp = new checkOutPage(driver);
      
      selectShippingAddress(cp);
      
      selectPaymentMethod(cp);
		
		
	}
	
  //guest checkout
  private void clickContinueAsGuest() throws InterruptedException {
      List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
      logger.info(continueasAGuest.size());

      if (continueasAGuest.size() > 0) {
          guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
          guestLoginPage.clickOnGuestCheckOut();
          logger.info("Guest checkout");
          guestLoginPage.clickOnEmail(reEnterMail);
          logger.info("Guest mail again");
          guestLoginPage.clickOnContinueAsGuest();
          logger.info("Guest continue as guest");
          Thread.sleep(5000L);
        
      }
      
  }
  
  //shipping details
  
  private void selectShippingAddress(checkOutPage cp) throws InterruptedException {
      WebElement existingAddress = driver.findElement(By.xpath("//select[@name='shipmentSelector' and @id='shipmentSelector-default']"));
      List<WebElement> options1 = existingAddress.findElements(By.xpath("./option"));
      System.out.println(options1.size());

      if (options1.size() > 1) {
          logger.info("Address already exists");
      } else {
          cp.setFisrtName(fname);
          logger.info("Entered fname");
          cp.setLastname(lname);
          logger.info("Entered lname");
          WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
          Random random = new Random();
          int randomNumber = random.nextInt(900) + 100; // Generates a random number between 100 and 999
          address = String.valueOf(randomNumber);
          Address1.sendKeys(address);
          WebElement Address11 = driver.switchTo().activeElement();
          Actions actions = new Actions(driver);
          Thread.sleep(1000);
          Address11.sendKeys(Keys.ARROW_DOWN);
          Thread.sleep(1000);
          Address11.sendKeys(Keys.ARROW_DOWN);
          Address11.sendKeys(Keys.ENTER);
          cp.setPhone(phonenumber);
          logger.info("Entered phone number");
          Thread.sleep(10000L);
      }
  }
  
  //next payment
  
  private void selectPaymentMethod(checkOutPage cp) throws InterruptedException {
      cp.clickpaymentbutton(driver);
      logger.info("Clicked on the payment button");
      Thread.sleep(5000);
//      homePage hm = new homePage(driver);
//      hm.clickOnLogo();
      // Additional payment method steps...
   }

}
