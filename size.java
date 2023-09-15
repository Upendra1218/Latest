package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.testcases.baseClass;

public class size extends baseClass{

	public void selectSize(WebDriver driver) throws InterruptedException {
		
		//selecting attributes
			allElements(driver);
			
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     WebElement cartEnabled =driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if(cartEnabled.isEnabled()&& inStock.size()>0) {
		     pdp.clickcartbutton(driver);
		     System.out.println("Product added to cart");
		     test.info("Verifying Add to cart button in PDP");
		     if(cartEnabled.isDisplayed()) {
		    	 test.pass("Successfully clicked on add to cart button");
		     }else {
		    	 test.fail("Not clicked on add to cart button");
		     }
		     
	     }else {
	    	 System.out.println("Product is out of stock so searching for new product");
	    	 
	    	 	Thread.sleep(2000);
             	WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
                String countOfMinicart = minicartcount.getText();
                int minicartCountValue = Integer.parseInt(countOfMinicart);
                System.out.println("Minicart count is " +minicartCountValue);

	    	 navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);
	    	 
	    	 productListingPage plp = new productListingPage(driver);
	    	 plp.selectProductRandom(driver);
	    	 
	    	 selectSize(driver);
	    	 
	    	 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
             String countOfMinicartafteradding = minicartcountafteradding.getText();
             int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

		         if( minicartCountValueafteradding!= minicartCountValue) {
		        	 System.out.println("Product added to cart");
		            
		         }else {
		        	 System.out.println("Product is not added to cart");
		        	 
		         }	    	 
	     }
	     
	}
	
	public void allElements(WebDriver driver) throws InterruptedException {
		
		//to know the product type
	    List<WebElement> countofSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
        logger.info("countofSizeElement: "+countofSizeElement.size());
        
        List<WebElement> countofAccesSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
        logger.info("countofSizeElement: "+countofAccesSizeElement.size());
        //if incase size element is not there means need to find the what other element is there on the page and select that one 
        List<WebElement> countofmemorysize = driver.findElements(By.xpath("//select[contains(@class, 'select-memorySize')]"));
        logger.info("countofmemorysize: "+countofmemorysize.size());
        
        //size should be greater than one 
        if(countofSizeElement.size()>0) {
        
        //iterating the size elements more than one
	     for(int p = 1; p <= countofSizeElement.size(); p++) {
	    	 
           //Find the parent div element that contains size and width elements
             // WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

          //Verify the presence of size element within the parent div
   	       List<WebElement> sizeElements = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
   	       System.out.println("sizeElements:"+sizeElements.size());
   	       //Verify the presence of width element within the parent div
   	       List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class, 'select-width')]"));
   	       System.out.println("widthElements: "+widthElements.size());
  	       //Verify the presence of color element within the parent div
   	       List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class, 'select-color')]"));
   	       System.out.println("colorElement: "+colorElement.size());
   	       
   	       //validating the all the attributes are present in any pdp
   	       if(sizeElements.size()>0&&widthElements.size()>0&&colorElement.size()>0) {

   	    	//selcting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	//select the width
   	    	attributesSelection.widthSelection();
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();

   	       }else if(sizeElements.size()>0&&colorElement.size()>0) {
   	    	   
   	    	//selecting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();
   	    	   
   	       }
   	       
	     }
	     //selecting the memory size of the product
        }else if(countofmemorysize.size()>0) {
        	
   	    	attributesSelection.memorySelection();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();
        	logger.info("memory size");

        }else if(countofAccesSizeElement.size()>0){
        	
          	//selcting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
        	//size of acc
        	attributesSelection.AccsizeSelction();
        	
   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();
        }else {

   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();
        }
        Thread.sleep(3000);
	     }
	
	public void clickOnBuyNow(WebDriver driver) throws InterruptedException {
		//selecting attributes
			allElements(driver);
			
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	    List <WebElement> buyNowEnabled =driver.findElements(By.xpath("//button[contains(@class,'buy-now')]"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if((buyNowEnabled.size()>0)&& inStock.size()>0) {
	    	 Thread.sleep(3000);
		     pdp.clickbuyNowButton(driver);
		     System.out.println("Product added to cart by Buy now button");
		     Thread.sleep(3000);
		     
		     WebElement buyNowEnabled1 =driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
		     test.info("Verifying Buy now button in PDP");
			     if(buyNowEnabled1.isDisplayed()) {
			    	 test.pass("Successfully clicked on buy now button");
			     }else {
			    	 test.fail("No  buy now button is clicked");
			     }
	     }else {
	    	 	System.out.println("Product is out of stock so searching for new product");	    	 
	    	 	Thread.sleep(2000);
	    	 	navigationPage navPage =new navigationPage(driver);
		    	navPage.selectRandomMenu(driver);
		    	 
		    	 productListingPage plp = new productListingPage(driver);
		    	 plp.selectProductRandom(driver);
		    	 
		    	 selectSize(driver);
		    	 
//		    	  List<WebElement> productsInCart = driver.findElements(By.xpath("//span[contains(@class,'order-receipt-label grand-total-label')]"));
//			         if(productsInCart.size()>0) {
//			        	 System.out.println("Product added to cart from buy now");
//			            
//			         }else {
//			        	 System.out.println("Product is not added to cart");
//			        	 
//			         }	    	 
	     }
	}
	
		public void paypalBuyNowFromPDP(WebDriver driver) throws InterruptedException {
			
			List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
			if(paypalbuyNowPdp.size()>0) {
			
			//selecting attributes
			  	 allElements(driver);
			  	 Thread.sleep(2000);
			  	
			  	 WebElement paypalbuyNowEnabled =driver.findElement(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
			     List<WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
			     if(paypalbuyNowEnabled.isEnabled()&& inStock.size()>0) {
			    	 productDescriptionPage pdp = new productDescriptionPage(driver);			    	 
			    	 pdp.clickOnPaypalBuyNow(driver);
			    	 
			    	 test.info("Verifying the paypal buy now button");
			    	  if (paypalbuyNowEnabled.isDisplayed()) {
			    		  test.pass("Succesffuly clicked on paypal buy noe button in pdp");
			    	  }
			    	  else {
			    		  test.fail("No  paypal buy now button in pdp");
			    	  }
			    	  
			     }else {
			    	 	System.out.println("Product is out of stock so searching for new product");
			    	 
			    	 	Thread.sleep(2000);
		             	WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		                String countOfMinicart = minicartcount.getText();
		                int minicartCountValue = Integer.parseInt(countOfMinicart);
		                System.out.println("Minicart count is " +minicartCountValue);

				    	navigationPage navPage =new navigationPage(driver);
				    	navPage.selectRandomMenu(driver);
				    	 
				    	productListingPage plp = new productListingPage(driver);
				    	plp.selectProductRandom(driver);
				    	 
				    	selectSize(driver);
			    	 
				    	WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
			            String countOfMinicartafteradding = minicartcountafteradding.getText();
			            int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

					         if( minicartCountValueafteradding!= minicartCountValue) {
					        	 System.out.println("Product added to cart");
					            
					         }else {
					        	 System.out.println("Product is not added to cart");
					        	 
					         }	    	 
			     }
			  
			}else {
				System.out.println("No paypal buy now button");
			}
		}
}
