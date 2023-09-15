package com.providio.commonfunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class selectAProduct extends baseClass{
	
	public void AddingAProductToCart() throws InterruptedException {
		
		driver.get(baseURL);
	    logger.info("enterd into url");
	    Thread.sleep(3000);
	    WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	    String countOfMinicart = minicartcount.getText();
	    int minicartCountValue = Integer.parseInt(countOfMinicart);
	    logger.info(minicartCountValue);
		
		navigationPage np = new navigationPage(driver);
		np.selectRandomMenu(driver);


		productListingPage plp = new productListingPage(driver);
		plp.selectProductRandom(driver);

	    Thread.sleep(3000);
	    
	    //selecting attributes
	    allAttributesinOneFile.allAttributes(); 
	    Thread.sleep(3000);
	    
	    test.info("Verifying the product is added to cart or not ");		
		 
	   WebElement minicartcountafteraddotcart = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	   String countOfMinicartafteraddotcart = minicartcountafteraddotcart.getText();
	   int minicartCountValueafteraddotcart = Integer.parseInt(countOfMinicartafteraddotcart);
	   logger.info(minicartCountValueafteraddotcart);

			  if(minicartCountValue!=minicartCountValueafteraddotcart) {
					test.pass("Product added to cart");
					logger.info("Product is  added to cart");
			  }else {
				  //pratciie.Paynent();
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			  }

			  
	}
	
	

}
