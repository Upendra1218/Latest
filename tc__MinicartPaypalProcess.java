package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;

public class tc__MinicartPaypalProcess extends baseClass{
		

	    public void checkoutprocessFromMiniCart() throws InterruptedException {


			WebElement minicartcount = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		    String countOfMinicart = minicartcount.getText();
		    int minicartCountValue = Integer.parseInt(countOfMinicart);
	        if (minicartCountValue > 0) {

	            miniCartPage mc = new miniCartPage(driver);
	            
	            	Thread.sleep(5000);
	                mc.clickcartbuttonjs(driver);
	                Thread.sleep(2000);
	  

	            validateMiniCartClick();
	                       
				//paypal checkout process

				List<WebElement> salesforceButton= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
				
				if(salesforceButton.size()>0) {
					logger.info("Salesforce paypal integration activated");
					mc.clickSalesforcePaypalButton();	
					//paypal window
					Thread.sleep(1000);
					//validatePaypalClick();
					
					paymentpPage pp =new paymentpPage(driver);
				}else {
					logger.info("Brain tree activated");
					mc.clickBrainTreePaypalButton();
				}	
				paymentpPage pp =new paymentpPage(driver);
				pp.paypalPopup(driver);
				logger.info("Entered into paypal window and entered the paypal details");

	        }
	        	
	        	
		        reviewOrderPage rop = new reviewOrderPage(driver);
				Thread.sleep(10000);
				rop.clickonplaceorderwithJsExuter(driver);
				logger.info("successfully click on the place order button");
				Thread.sleep(10000);
	    		System.out.println(driver.getTitle());
	    		
	    		//validate the final place the order page
				validatePlacetheOrderPage();
				
	            //ordernumberandOrderdate
				ordernumberandOrderdat();
				
	        /*
	    	if (driver.findElements(By.xpath("//button[contains(@class,'place-order')]")).size()>0) {   
	    		String mainWindowHandle = driver.getWindowHandle();
			    driver.switchTo().window(mainWindowHandle);
	    		rop.clickonplaceorderwithJsExuter(driver);		
	    		logger.info("successfully click on the place order button");
	    		}*/
	        
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
			  
			           //validate minicart
			            validateMiniCartClick();
			            logger.info("Validated minicart");
			            
			            mc.clickviewCartButton();
			            logger.info("Clicked on view cart button"  );
			            
			            validateViewCartClick();
			            logger.info("Validated the view cart ");
			            
			            viewCartPage vcp = new viewCartPage(driver);
			            
			            List<WebElement> payPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				            if(payPalButton.size()>0) {
				            	 logger.info("Braintree payment integration is activated");
				            	 vcp.clickPayPalButton(driver);
				            }else {
				            	logger.info("Salesforce payment integration is activated");
				            }
				        	paymentpPage pp =new paymentpPage(driver);
				        	Thread.sleep(2000);
				        //validate paypal window
				        	validatePaypalClick();
							pp.paypalPopup(driver);
							logger.info("Entered into paypal window and entered the paypal details");
	 		   }
		 		   
			 		  	reviewOrderPage rop = new reviewOrderPage(driver);
						Thread.sleep(10000);
						rop.clickonplaceorderwithJsExuter(driver);
						logger.info("successfully click on the place order button");
						Thread.sleep(10000);
			    		System.out.println(driver.getTitle());
			    		
			    		//validate the final place the order page
						validatePlacetheOrderPage();
						
			            //ordernumberandOrderdate
						ordernumberandOrderdat();              
	 		}
	        
	        private void validateViewCartClick() {
	        	test.info("Verify the view-cart button is clicked");
	            WebElement viewcart = driver.findElement(By.xpath("//h4"));
	            String actualTitleofviewcart = viewcart.getText();
	            String expectedTitleviewcart = "Order Summary";
	            logger.info(viewcart.getText());
	            if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
	                test.pass("Successfully clicked on the view cart button");
	                logger.info("Successfully clicked on the view cart button");
	            } else {
	                test.fail("Clicked failed on the view cart button");
	                logger.info("Clicked failed on the view cart button");
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
	                //reClickMiniCartButton();
	                
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
//	            WebElement paypal = driver.findElement(By.xpath("//div[contains(@class, 'paypal-button') and contains(@class, 'paypal-button-number-0') and contains(@class, 'paypal-button-layout-vertical') and contains(@class, 'paypal-button-shape-rect') and contains(@class, 'paypal-button-env-sandbox') and contains(@class, 'paypal-button-color-gold') and contains(@class, 'paypal-button-text-color-black') and contains(@class, 'paypal-logo-color-blue') and @role='link' and @aria-label='PayPal Checkout']"));
//	            boolean displaypaypal = paypal.isDisplayed();
	            if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
	            	test.pass("Successfully displayed the viewcart, checkout, paypal buttons and products, The number of products are: "+ productsinthecart.size());
	                logger.info("Successfully displayed the viewcart, checkout, paypal buttons and products");
	            	
	            }else {
	                test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
	                logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
	            }
	        }
	        
	        
	        private void reClickMiniCartButton() throws InterruptedException {
	        	
	        	miniCartPage mc = new miniCartPage(driver);
	            mc.clickcartbutton(driver);
	            
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
	        
	        //paypal window validation
	        private void validatePaypalClick() {
	        	
	        	//driver.getCurrentUrl();
	        	System.out.println(driver.getTitle());
	        	/*
	        	WebElement paypalWindow = driver.findElement(By.xpath("//h1[contains(@class,'headerText')]"));
	        	String actualPaypaltext= paypalWindow.getText();
	        	String expectedPaypalText="";
	        	if(paypalWindow.isDisplayed()) {
	        		test.info("Validating paypal window");
	        		test.pass("Succesfully opened the Paypal window ");
	        		logger.info("Succesfully opened the Paypal window ");
	        	}else {
	        		test.info("Succesfully opened the Paypal window ");
	        		logger.info("Succesfully opened the Paypal window ");
	        	}*/
	        }
	        
	    	//validate the order number and date of order
	    	private void ordernumberandOrderdat() {
	    		
	    		//displayordernumberandplaceddate
	    	    
	    	    WebElement orderNumeber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
	    	    String Ordernumber = orderNumeber.getText();
	            test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
	            logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
	    	    
	    	    //order date
	    	    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
	            String Orderdate = OrderDate.getText();
	            test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
	    		
	    	}
	    	
	    	
	    	//validate the place the order page
	        private void validatePlacetheOrderPage() throws InterruptedException {
	        	
	        	test.info("verify that order is placed");
	    		
	    		//validate the orderstatus
	        	Thread.sleep(3000);
	    	    WebElement PlacetheOrder = driver.findElement(By.xpath("//h2[@class ='order-thank-you-msg']"));
	    	    String ActualTitleofPlacetheOrder = PlacetheOrder.getText();
	    	    String ExpectedTitlePlacetheOrder = "Thank you for your order.";
	    	    logger.info(PlacetheOrder.getText());
	    	    
	    	    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
	    	        test.pass("Successfully Order is Placed");
	    	        logger.info("Successfully Order is Placed");
	    	    } else {
	    	        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
	    	        logger.info("Click failed");
	    	    }
	    	    
	    	    Thread.sleep(5000);
	        	
	        }
}
