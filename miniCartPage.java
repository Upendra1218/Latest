package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class miniCartPage {

WebDriver lDriver;
	
	public miniCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//cartbutton
	@FindBy(xpath="//a[contains(@class, 'minicart')]")
	WebElement CartButton;
	public void clickcartbutton(WebDriver driver) throws InterruptedException{
		
		CartButton.click();
		Thread.sleep(2000);
		
	}
	
	//js
	@FindBy(xpath="//a[contains(@class, 'minicart')]")
	WebElement CartButtonjs;
	public void clickcartbuttonjs(WebDriver driver) throws InterruptedException{

			JavascriptExecutor js = (JavascriptExecutor) driver;
  	        js.executeScript("arguments[0].click();", CartButton);
	       

	}
	
	//viewCartButton
	@FindBy(xpath="//a[contains(text(), 'View Cart') ]")
	WebElement viewCartButton;
	public void clickviewCartButton() throws InterruptedException{	
		viewCartButton.click();	
        Thread.sleep(2000);
	}
	
	//checkoutminicart
	

	@FindBy(xpath="//a[contains(@class, 'checkout-btn') and contains(., 'Checkout')]")
	WebElement checkoutminicart;
	public void clickcheckoutminicart() throws InterruptedException{	
		checkoutminicart.click();	
        Thread.sleep(2000);
	}

	
	//Checkout
	@FindBy(xpath="//a[contains(text(), 'Checkout') ]")
	WebElement Checkout;
	public void clickCheckout() throws InterruptedException{
		
		Checkout.click();	
        Thread.sleep(5000);
	}
	
	
	//paypal
	
//	@FindBy(xpath="//div[@role='link' and contains(@class, 'paypal-button') and @data-funding-source='paypal']")
//	WebElement paypalButton ;
//	public void clickpaypalButton () throws InterruptedException{
//		
//		paypalButton.click();	
//        Thread.sleep(5000);
//	}
	
	@FindBy(xpath="//div[contains(@class,'js_braintree_paypal_cart_button')]")

	WebElement brainTreePaypalButton ;

	public void clickBrainTreePaypalButton () throws InterruptedException{

	 

	brainTreePaypalButton.click();

	Thread.sleep(5000);

	}

	//paypal by salesforce integration

	@FindBy(xpath = "//div[contains(@class,'salesforce')]")

	WebElement salesforcePaypalButton;

	public void clickSalesforcePaypalButton() {

	salesforcePaypalButton.click();

	}
	

	
}
