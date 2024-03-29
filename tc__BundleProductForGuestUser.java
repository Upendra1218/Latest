package com.providio.testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.bundleProductAddAllToCart;

public class tc__BundleProductForGuestUser  extends baseClass{
	
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {

			 driver.get(baseURL);
			 logger.info("Entered into url");
			 logger.info("Placing the order as guest user");
			 
			 //chesking the minicart count
			 	Thread.sleep(2000);
	            WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	            String countOfMinicart = minicartcount.getText();
	            int minicartCountValue = Integer.parseInt(countOfMinicart);
	            logger.info(minicartCountValue);
	            
			 //searching the bundle product from excel sheet
			 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
			 bundleProduct.performRandomOperations(driver);
			 logger.info("Searched a product");
			 
	   	        //validate the product is instock or not
	   	    	validatingInstock.inStockValidation();

	   	    	Thread.sleep(3000);
			 	WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	            String countOfMinicartafteradding = minicartcountafteradding.getText();
	            int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

	            logger.info(minicartCountValueafteradding);

		     //validation for product add to cart
		        test.info("Verifying the product is added to cart or not ");

			        if( minicartCountValueafteradding!= minicartCountValue) {
			            test.pass("Product added to cart");
			            logger.info("Product is  added to cart");
			        }else {
			            test.fail("Product is not added to cart");
			            logger.info("Product is not added to cart");
			        }
				
	         //checkoutProcess		        
					tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();         
					cp.checkoutprocess();
              
//			              //payment process
              tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
              tc.paymentByCreditCard();
				}

		 
}
