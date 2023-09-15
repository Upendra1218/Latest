

package com.providio.testcases;

import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();
    //tc__LoginSc.verifySuccessfulLogin, tc__Login.loginTest com.providio.testcases.tc__LoginSc.verifySuccessfulLogi
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
    	
    	//validate the user login or not 
    	
        if (isLoggedIn) {
        	
        	//Home page 
            homePage homepage = new homePage(driver);
            homepage.clickOnSearchBar(this.searchBar);
            logger.info("searched a product " + this.searchBar);
            
            homepage.clickOnSearchedProduct();
            logger.info("clicked on searched product");
            Thread.sleep(3000);
            
            //plp page
   	    	//validate the product is instock or not
   	    	validatingInstock.inStockValidation();

	        //checkoutProcess
	        
   	    	tc__MiniCartChekoutButton cp = new tc__MiniCartChekoutButton();
            
            cp.checkoutprocess();
            
            //payment process
            
           //payment process
            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
            
            cc.paymentByCreditCard(); 
            
      
            Thread.sleep(10000L);
        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }
}