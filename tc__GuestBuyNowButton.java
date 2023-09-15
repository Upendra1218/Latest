

package com.providio.testcases;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__GuestBuyNowButton extends baseClass {
	SoftAssert softAssert = new SoftAssert();


    @Test
    public void guestlogin() throws InterruptedException {
    	
        driver.get(this.baseURL);
        logger.info("enterd into url");
        
		
		navigationPage np = new navigationPage(driver);
		np.selectRandomMenu(driver);


		productListingPage plp = new productListingPage(driver);
		plp.selectProductRandom(driver);
		
		

        Thread.sleep(3000);
        
        //finding the how many size elements are there in the page and after that itterating the how many size elements need to select the each one 
        List<WebElement> countofSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
        logger.info("countofSizeElement: "+countofSizeElement.size());
        //if incase size element is not there means need to find the what other element is there on the page and select that one 
        List<WebElement> countofmemorysize = driver.findElements(By.xpath("//select[contains(@class, 'select-memorySize')]"));
        logger.info("countofmemorysize: "+countofmemorysize.size());
      
        
        
        //size should be greater than one 
        if(countofSizeElement.size()>0) {
        
        //iterating the size elements more than one
	     for(int p = 1; p <= countofSizeElement.size(); p++) {
	    	 
           //Find the parent div element that contains size and width elements
              WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

          //Verify the presence of size element within the parent div
   	       List<WebElement> sizeElements = parentDiv.findElements(By.xpath(".//select[contains(@class, 'select-size')]"));
   	       System.out.println("sizeElements:"+sizeElements.size());
   	       //Verify the presence of width element within the parent div
   	       List<WebElement> widthElements = parentDiv.findElements(By.xpath(".//select[contains(@class, 'select-width')]"));
   	       System.out.println("widthElements: "+widthElements.size());
  	       //Verify the presence of color element within the parent div
   	       List<WebElement> colorElement = parentDiv.findElements(By.xpath(".//select[contains(@class, 'select-color')]"));
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
   	        productDescriptionPage pdp = new productDescriptionPage(driver);
   	        
   	        pdp.clickbuyNowButton(driver);

   	       }else if(sizeElements.size()>0&&colorElement.size()>0) {
   	    	   
   	    	//selecting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	        productDescriptionPage pdp = new productDescriptionPage(driver);
   	        
   	        pdp.clickbuyNowButton(driver);
   	    	   
   	       }
   	       
	     }
	     //selecting the memory size of the product
        }else if(countofmemorysize.size()>0) {
        	
   	    	attributesSelection.memorySelection();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	        productDescriptionPage pdp = new productDescriptionPage(driver);
   	        
   	        pdp.clickbuyNowButton(driver);
        	logger.info("memory size");

        }else {
        	
   	    	//validate the product is instock or not
            productDescriptionPage pdp = new productDescriptionPage(driver);
   	        
   	        pdp.clickbuyNowButton(driver);
        }
        Thread.sleep(3000);
        
        
        //checkout process
        checkOutProcessBuyNow cp = new checkOutProcessBuyNow();
        cp.buynow();

        //payment process
        
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
	     
	     cc.paymentByCreditCard();
    }
    

}