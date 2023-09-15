package com.providio.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reviewOrderPage {
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath ="//button[contains(text(), 'Place Order')]")
	WebElement placetheorder;
    public void clickonplaceorder(WebDriver driver) throws InterruptedException {	 
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement clikconplace = wait.until(ExpectedConditions.elementToBeClickable(placetheorder));		
    	clikconplace.click();
    }
    
	@FindBy(xpath ="//button[contains(text(), 'Place Order')]")
	WebElement placetheorderwithJsExuter;
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {	
    	if(driver.findElements(By.xpath("//button[contains(text(), 'Place Order')]")).size()!=0) {
    	try {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placetheorderwithJsExuter);
    	Thread.sleep(2000);
    	placetheorderwithJsExuter.click();
    
    
    	}catch(Exception e) {
    		Thread.sleep(2000);
    		JavascriptExecutor js = (JavascriptExecutor) driver; 
    		js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
    	}
      }
    }
    
    public void trackTheOrderId(WebDriver driver) {
        WebElement orderID = driver.findElement(By.xpath("//span[contains(@class, 'summary-details order-number')]"));
        String orderIDtext= orderID.getText();
        System.out.println("Thank you for your order");
        System.out.println("Order Number " + orderIDtext);

 

    } 


}
