

package com.providio.testcases;

import com.providio.commonfunctionality.selectAProduct;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__GuestUser extends baseClass {
	SoftAssert softAssert = new SoftAssert();


    @Test
    public void guestlogin() throws InterruptedException {
    	      //adding a product to the cart
    	
    	      selectAProduct Product = new selectAProduct();
    	      Product.AddingAProductToCart();
        
			  //checkoutProcess		        
			  tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
              cp.checkoutprocess();
              
//              //payment process
              tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();
              
              tc.paymentByCreditCard();
    }
}