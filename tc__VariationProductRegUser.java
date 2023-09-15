package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;


public class tc__VariationProductRegUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {

			 Thread.sleep(3000);

			 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	         String countOfMinicart = minicartcount.getText();
	         int minicartCountValue = Integer.parseInt(countOfMinicart);	        
	         logger.info(minicartCountValue);
	         
			 //searched for variation product
			 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			 fromExcel.performRandomOperations(driver);
			 logger.info("searched for Variation product");

			    attributesSelection.colorSelection();
	   	    	Thread.sleep(3000);
	   	    	//select the size
	   	    	attributesSelection.sizeSelction();
	   	    	Thread.sleep(3000);
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
	         
	         //payment by credit card

		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();	     
		     cc.paymentByCreditCard();

		 }
		 
		  else {
		        Assert.fail("User not logged in");
		    }
	 }
}

