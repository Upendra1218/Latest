package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bundleProductAddAllToCart {

	
	public void addAllToCart(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
 		WebElement elementXPath = driver.findElement(By.xpath("//div[@class='col-12 col-sm-6 offset-sm-6 bundle-footer']"));
 		List<WebElement>  inStock = elementXPath.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));

 	    // Check if the element is present
 	    if (inStock.size()> 0 ) {

	 	       	WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
				if(!addAllToCartElement.isEnabled()) {
					System.out.println("out of stock");
				}else {
					Thread.sleep(5000);
					js.executeScript("arguments[0].click();", addAllToCartElement);
					System.out.println("All products added to cart");
					Thread.sleep(5000);	       	
	 	           	System.out.println("Product is availble");
	 	           
				}
			}
	}
}
