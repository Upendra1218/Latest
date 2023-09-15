package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.miniCartPage;

public class pp extends baseClass{

	@Test
	public void Paynent() throws InterruptedException {
		
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/electronics/ipod%20%26%20mp3%20players/apple-ipod-touchM.html?lang=en_US");
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/womens/clothing/outfits/in-store-setM.html?lang=en_US");
		
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/charcoal-single-pleat-striped-wool-suit/25686364M.html?lang=en_US");
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/womens/jewelry/earrings/womens-jewelry-bundleM.html?lang=en_US");
		
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/jewel-neck-jacket/25696540M.html?lang=en_US");
		
		driver.get(baseURL);
	

		    logger.info("enterd into url");
	        Thread.sleep(30000);
	        
		
           miniCartPage mc = new miniCartPage(driver);
            
            Thread.sleep(5000);
               
            //click on the cart button
            mc.clickcartbuttonjs(driver);
            
            Thread.sleep(5000);
		
		List<WebElement> noofPlusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-plus']"));
		logger.info(noofPlusElementsPresent.size());
		for(int i = 1;i<=noofPlusElementsPresent.size();i++) {	
			WebElement eachPlusElement = driver.findElement(By.xpath("(//span[@class ='qty-plus'])[" + i + "]"));
			eachPlusElement.click();
            Thread.sleep(2000);
			eachPlusElement.click();
			Thread.sleep(2000);
		}
		
		Thread.sleep(3000);
		List<WebElement> noofminusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-minus']"));
		logger.info(noofminusElementsPresent.size());
		for(int i = 1;i<=noofPlusElementsPresent.size();i++) {
			WebElement eachminusElement = driver.findElement(By.xpath("(//span[@class ='qty-minus'])[" + i + "]"));
			eachminusElement.click();
            Thread.sleep(2000);
			eachminusElement.click();
			Thread.sleep(2000);
		}
	}

}
