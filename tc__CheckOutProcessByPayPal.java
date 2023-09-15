package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.Checkout_Validation;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class tc__CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();
	 
	    public void checkoutprocessFromMiniCart() throws InterruptedException {


			WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		    String countOfMinicart = minicartcount.getText();
		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	        if (minicartCountValue > 0) {

	            miniCartPage mc = new miniCartPage(driver);
	            
	            	Thread.sleep(5000);
	                mc.clickcartbuttonjs(driver);
	                Thread.sleep(2000);
	  
	                //Checkout_Validation checkout= new Checkout_Validation();
	                checkout.validateMiniCartClick();
	                       
				//paypal checkout process

				List<WebElement> salesforceButton= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
				
				if(salesforceButton.size()>0) {
					logger.info("Salesforce paypal integration activated");
					mc.clickSalesforcePaypalButton();	
					//paypal window
					
					
					paymentpPage pp =new paymentpPage(driver);
				}else {
					logger.info("Brain tree activated");
					mc.clickBrainTreePaypalButton();
				}	
					paymentpPage pp =new paymentpPage(driver);
					Thread.sleep(3000);
					checkout.validatePaypalClick();
					pp.paypalPopup(driver);
					logger.info("Entered into paypal window and entered the paypal details");
					
					

	        }
	        	
		       //review order page
			        reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(10000);
				
					rop.clickonplaceorderwithJsExuter(driver);
					logger.info("successfully click on the place order button");
					Thread.sleep(10000);
		    		System.out.println(driver.getTitle());
				
		    		 //Checkout_Validation checkout= new Checkout_Validation();
	    		//validate the final place the order page
		    		 checkout.validatePlacetheOrderPage();
				
	            //ordernumberandOrderdate
		    		 checkout.ordernumberandOrderdat();

	 }
	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {

	 			WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 		    String countOfMinicart = minicartcount.getText();
	 		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	 			//count of items in minicart 
		 		   if (minicartCountValue > 0) {
	
			            miniCartPage mc = new miniCartPage(driver);
			            
			            	Thread.sleep(5000);
			                mc.clickcartbuttonjs(driver);
			                Thread.sleep(2000);
			               // Checkout_Validation checkout= new Checkout_Validation();
			                
				           //validate minicart
				           checkout.validateMiniCartClick();
				            logger.info("Validated minicart");
				            
				            mc.clickviewCartButton();
				            logger.info("Clicked on view cart button"  );
				            
				            checkout.validateViewCartClick();
				            logger.info("Validated the view cart ");
				            
				            viewCartPage vcp = new viewCartPage(driver);
			            
			            List<WebElement> payPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				            if(payPalButton.size()>0) {
				            	 logger.info("Braintree payment integration is activated");
				            	 vcp.braintreePayPalButton(driver);
				            }else {
				            	logger.info("Salesforce payment integration is activated");
				            	vcp.salesforcePayPalButton(driver);
				            	
				            }
				        	paymentpPage pp =new paymentpPage(driver);
				        	Thread.sleep(2000);
				        //validate paypal window
				       // checkout.validatePaypalClick();
							pp.paypalPopup(driver);
							logger.info("Entered into paypal window and entered the paypal details");
	 		   }
		 		   
			 		  	reviewOrderPage rop = new reviewOrderPage(driver);
						Thread.sleep(10000);
						rop.clickonplaceorderwithJsExuter(driver);
						logger.info("successfully click on the place order button");
						Thread.sleep(10000);
			    		System.out.println(driver.getTitle());
			    		
			    		 //Checkout_Validation checkout= new Checkout_Validation();
			    		//validate the final place the order page
			    		 checkout.validatePlacetheOrderPage();
						
			            //ordernumberandOrderdate
			    		 checkout.ordernumberandOrderdat();              
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {
	    	
	    	//payment page
			
							
				List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));		    	
		    	System.out.println(brainPaypalAcc.size());
		    	
		    	List<WebElement> salesforcePaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));		    	
		    	System.out.println(salesforcePaypalAcc.size());
	    	
	    	if(brainPaypalAcc.size()>0) {
	    		
	    		test.info("Brain tree payment integration is activated");
	    		paymentpPage pp =new paymentpPage(driver);	    		
	    		pp.braintreePaypal(driver);

	    	}else {	 
	    		test.info("salesoforce payment integration is activated");
			    paymentpPage pp = new paymentpPage(driver);
			    JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,500)", "");
			    pp.salesforcePaypalCheckout(driver);

	    	}
	    		
	    	paymentpPage pp =new paymentpPage(driver);
	    	pp.paypalPopup(driver);

	    	// review order page
	    		reviewOrderPage rop = new reviewOrderPage(driver);
//	    		if(driver.findElements(By.xpath("//button[contains(text(), 'Next: Review Order')]")).size()!=0) {
//		    		rop.clickonplaceorder(driver);
//		    		logger.info("Clicked on review order button");
//		    		Thread.sleep(2000);
//	    		}else {
//	    			logger.info("Paypal checkout as reg user");
//	    		}
	    		
	    		if (driver.findElements(By.xpath("//button[contains(text(), 'Place Order')]")).size()!=0) {   		
		    		rop.clickonplaceorderwithJsExuter(driver);		
		    		logger.info("successfully click on the place order button");
		    		}
//	    		else {
//	    			System.out.println("For Salesforce no place order button is there");
//	    		}
			
			 Thread.sleep(10000);
			 //Checkout_Validation checkout= new Checkout_Validation();
	    		//validate the final place the order page
	    		 checkout.validatePlacetheOrderPage();
				
	            //ordernumberandOrderdate
	    		 checkout.ordernumberandOrderdat();  
		  
			}
	  
	    
	    public void paypalCheckoutFromPDP() throws InterruptedException {
 
	 			    Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				
	 				reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(10000);
					rop.clickonplaceorderwithJsExuter(driver);
					logger.info("successfully click on the place order button");
					Thread.sleep(10000);
		    		System.out.println(driver.getTitle());
		    		
		    		// Checkout_Validation checkout= new Checkout_Validation();
		    		//validate the final place the order page
		    		 checkout.validatePlacetheOrderPage();
					
		            //ordernumberandOrderdate
		    		 checkout.ordernumberandOrderdat();  
	 		  
	    }
}
