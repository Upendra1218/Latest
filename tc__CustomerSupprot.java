package com.providio.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.contactUsCustomerSupport;

public class tc__CustomerSupprot extends baseClass{
	@Test
	//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void customerSuppor() throws InterruptedException {
		 driver.get(this.baseURL);
	        logger.info("enterd into url");
		Thread.sleep(5000);
		
		
		
		contactUsCustomerSupport csp = new contactUsCustomerSupport(driver);
		csp.clickcustomerSupportButton(driver);
		logger.info("Clicked on the customer support button");
		
		Thread.sleep(15000);
		
		csp.sendNameoftheCustomer(driver);
		logger.info("sucessfully Name send to the input of the name field");
		Thread.sleep(1000);
		
		//csp.sendlastNameoftheCustomer(driver);
		
		//csp.sendPhone(driver);
		
		
        csp.sendSubject(driver);
        logger.info("sucessfully subject send to the input of the name field");
        Thread.sleep(1000);
        
        csp.sendEmailofTheCustomer(driver);
        logger.info("sucessfully Email send to the input of the name field");
        Thread.sleep(1000);
        
        csp.selecttheIssuesoftheCustomer(driver);
        logger.info("sucessfully select the reason for the feedback");
        Thread.sleep(1000);
        
        csp.clicksubmitButton(driver);
        logger.info("sucessfully clicked on the submit button");
        Thread.sleep(5000);
        
//        csp.clickcancelButton(driver);
//        logger.info("sucessfully clicked on the cancel button");
//        Thread.sleep(5000);
        
//        csp. clickleaveButton(driver);
//        logger.info("sucessfully clicked on the cancel button");
//        Thread.sleep(5000);

        test.info("Verify that the feedback is submitted.");
        WebElement donebutton = driver.findElement(By.xpath("//span[contains(text(), 'Done')]"));

		  boolean isDsiplayed = donebutton.isDisplayed();

		  if (isDsiplayed) {
		      System.out.println("Button is displayed");
		        csp.clickdoneButton(driver);
		        logger.info("sucessfully clicked on the done button");
			  test.pass("Feedback submitted successfully");
		      
		  } else {
		      System.out.println("Button is disabled");
		      test.fail("Feedback not submitted successfully");
		  }
		  

	}
	
}
