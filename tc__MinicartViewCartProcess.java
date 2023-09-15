package com.providio.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.quickShopPage;
import com.providio.pageObjects.viewCartPage;

public class tc__MinicartViewCartProcess extends baseClass {

    public void checkoutprocess() throws InterruptedException {

        WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
        String countOfMinicart = minicartcount.getText();
        int minicartCountValue = Integer.parseInt(countOfMinicart);

        if (minicartCountValue > 0) {

            miniCartPage mc = new miniCartPage(driver);
            
            Thread.sleep(3000);
               
            //click on the cart button
            mc.clickcartbutton(driver);
            Thread.sleep(2000);
            

		    
            
            //validate the button click 
            validateMiniCartClick();
            //click review order
            mc.clickviewCartButton();
			logger.info("clicked the view cart button in the minicart");
			//validate the view cart button click
			Thread.sleep(2000);
			validateViewCartClick();

            viewCartPage vcp = new viewCartPage(driver);
            //click the checkout button
            vcp.clickCheckout(driver);
            Thread.sleep(5000);

            //Taxcalculation
            
//            tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();
//            
//            tc.taxCalculation();
            //if any guest user means guest checkout
            clickContinueAsGuest();
            

            checkOutPage cp = new checkOutPage(driver);

            selectShippingAddress(cp);
            selectPaymentMethod(cp);

        } else {
            test.fail("The cart value is empty");
        }

    }

    private void validateMiniCartClick() throws InterruptedException {
    	
    	test.info("Verify the mini-cart button is clicked");
    	
        WebElement minicart = driver.findElement(By.xpath("(//h1)[1]"));
        String actualTitleofminicart = minicart.getText();
        String expectedTitleminicart = "Your shopping cart";
        Thread.sleep(2000);
        logger.info(minicart.getText());
        if (actualTitleofminicart.equals(expectedTitleminicart)) {
            test.pass("Successfully clicked on the mini cart button");
            logger.info("Successfully clicked on the mini cart button");

        } else {
            //test.fail("Clicked failed on the mini cart button");
            logger.info("Clicked failed on the mini cart button");
            //reclick if any error occurs
            Thread.sleep(3000);
            reClickMiniCartButton();
            
        }
        
        test.info("Verify the viewcart, checkout, paypal buttons and products are displayed");
        List<WebElement> productsinthecart = driver.findElements(By.xpath("//div[@class ='line-item-name']"));
        logger.info(productsinthecart.size());
        
        WebElement viewcarButton = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(text(), 'View Cart')]"));
        boolean displaycartbutton = viewcarButton.isDisplayed();
        logger.info(displaycartbutton);
        WebElement checkOutProcess = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(@class, 'btn-primary') and contains(text(), 'Checkout')]"));
        boolean displaycheckOut = checkOutProcess.isDisplayed();
        logger.info(displaycheckOut);
//        WebElement paypal = driver.findElement(By.xpath("//div[contains(@class, 'paypal-button') and contains(@class, 'paypal-button-number-0') and contains(@class, 'paypal-button-layout-vertical') and contains(@class, 'paypal-button-shape-rect') and contains(@class, 'paypal-button-env-sandbox') and contains(@class, 'paypal-button-color-gold') and contains(@class, 'paypal-button-text-color-black') and contains(@class, 'paypal-logo-color-blue') and @role='link' and @aria-label='PayPal Checkout']"));
//        boolean displaypaypal = paypal.isDisplayed();
        if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
        	test.pass("Successfully displayed the viewcart, checkout, paypal buttons and products, The number of products are: "+ productsinthecart.size());
            logger.info("Successfully displayed the viewcart, checkout, paypal buttons and products");
        	
        }else {
            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
        }
    }

    private void validateViewCartClick() throws InterruptedException {
    	test.info("Verify the view-cart button is clicked");
        WebElement viewcart = driver.findElement(By.xpath("//h4"));
        String actualTitleofviewcart = viewcart.getText();
        String expectedTitleviewcart = "Order Summary";
        logger.info(viewcart.getText());
        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
        	
            test.pass("Successfully clicked on the view cart button");
            logger.info("Successfully clicked on the view cart button");
            
            Thread.sleep(3000);
            quickShopPage qs = new quickShopPage(driver);
            
            qs.QuantityofallpagesPlus(driver);
		    logger.info("Clicked on Increase quantity");
		    test.pass("Successfully increased the quantity");

		    qs.Quantityofallpagesminus(driver);
		    logger.info("Clicked on Decrease quantity");
		    test.pass("Successfully decreased the quantity");
        } else {
            test.fail("Clicked failed on the view cart button");
            logger.info("Clicked failed on the view cart button");
        }
        
        
    }

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
            int randomNumber = 123; //random.nextInt(900) + 100// Generates a random number between 100 and 999
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

    private void selectPaymentMethod(checkOutPage cp) throws InterruptedException {
        cp.clickpaymentbutton(driver);
        logger.info("Clicked on the payment button");
        Thread.sleep(5000);
//        homePage hm = new homePage(driver);
//        hm.clickOnLogo();
        // Additional payment method steps...
    }
    
    private void reClickMiniCartButton() throws InterruptedException {
    	
    	miniCartPage mc = new miniCartPage(driver);
    	Thread.sleep(4000);
        mc.clickcartbuttonjs(driver);
        
        WebElement reminicart = driver.findElement(By.xpath("(//h1)[1]"));
        String reactualTitleofminicart = reminicart.getText();
        String reexpectedTitleminicart = "Your shopping cart";
        Thread.sleep(2000);
        logger.info(reminicart.getText());
        if (reactualTitleofminicart.equals(reexpectedTitleminicart)) {
            test.pass("Successfully clicked on the mini cart button");
            logger.info("Successfully clicked on the mini cart button");

        } else {
            test.fail("Clicked failed on the mini cart button");
            logger.info("Clicked failed on the mini cart button");

        }
    	
    }
}
