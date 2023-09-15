package com.providio.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;


public class tc__NavigationEachMenuOneItem extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void Navigation() throws InterruptedException {
        test.info("Test case for the Login Page");
        
        if (isLoggedIn) {
            test.info("Test case for the Navigationmenu of Newarrival Page");
            

   		 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
           String countOfMinicart = minicartcount.getText();
           int minicartCountValue = Integer.parseInt(countOfMinicart);
           logger.info(minicartCountValue);
            
            
            List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();

	        Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            int randomNumbermenuitem = random.nextInt(countdropdown)+1;

	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                test.pass ("Successfully Howered on the" + menuname + " ");
	                logger.info("Successfully Howered on the" + menuname + " ");

	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	                Thread.sleep(5000L);
	                
	                test.pass( "Successfully clicked on the" + submenuName + " of " + menuname + "");
	                logger.info("Successfully clicked on the" + submenuName + " of " + menuname + "");
	                
           
	                List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));	    	        
	    	        int totalProductcount = products.size();	    	        
	    	        int randomselectProduct = random.nextInt(totalProductcount) + 1;

	    	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])"+"  "+"[" + randomselectProduct + "]"));
	    	       // String productName = RandomSelectProductFormPLP.getText();
	    	        //logger.info(productName);
	    	        js.executeScript("arguments[0].click();",  RandomSelectProductFormPLP);
	    	        
	    	        
	    	        //logger.info(productName);
	    	        Thread.sleep(5000);
	    	        
	    	        
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

	    	        }else {
	    	        	
	    	   	    	//validate the product is instock or not
	    	   	    	validatingInstock.inStockValidation();
	    	        }
	    	        Thread.sleep(3000);
	    	        
	    	        test.info("Verifying the product is added to cart or not ");		
	    			 
	    			 WebElement minicartcountafteraddotcart = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	    	       String countOfMinicartafteraddotcart = minicartcountafteraddotcart.getText();
	    	       int minicartCountValueafteraddotcart = Integer.parseInt(countOfMinicartafteraddotcart);
	    	       logger.info(minicartCountValueafteraddotcart);

	    				  if(minicartCountValue!=minicartCountValueafteraddotcart) {
//	    					  Thread.sleep(5000);
//	    					  pratciie.Paynent();
	    						test.pass("Product added to cart");
	    						logger.info("Product is  added to cart");
	    				  }else {
	    					  //pratciie.Paynent();
	    					test.fail("Product is not added to cart");
	    					logger.info("Product is not added to cart");
	    				  }
	    	        Thread.sleep(5000);

	               
	            }
	        
	        //checkoutProcess
	        
            tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();
            
            cp.checkoutprocess();
            
           //payment process
            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
            
            cc.paymentByCreditCard(); 
            

            
        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }

}
