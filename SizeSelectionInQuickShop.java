package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;

public class SizeSelectionInQuickShop {

	
	public void sizeSelectionInQuickShop(WebDriver driver) throws InterruptedException {

		 List<WebElement> countofSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
	       // logger.info("countofSizeElement: "+countofSizeElement.size());
	        
	        List<WebElement> countofAccesSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
	        //logger.info("countofSizeElement: "+countofAccesSizeElement.size());
	        //if incase size element is not there means need to find the what other element is there on the page and select that one 
	        List<WebElement> countofmemorysize = driver.findElements(By.xpath("//select[contains(@class, 'select-memorySize')]"));
	        //logger.info("countofmemorysize: "+countofmemorysize.size());
	        
	        //size should be greater than one 
	        if(countofSizeElement.size()>0) {
	        
	        //iterating the size elements more than one
		     for(int p = 1; p <= countofSizeElement.size(); p++) {
		    	 
	           //Find the parent div element that contains size and width elements
	             // WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

	          //Verify the presence of size element within the parent div
	   	       List<WebElement> sizeElements = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
	   	       System.out.println("sizeElements:"+sizeElements.size());
	   	       //Verify the presence of width element within the parent div
	   	       List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class, 'select-width')]"));
	   	       System.out.println("widthElements: "+widthElements.size());
	  	       //Verify the presence of color element within the parent div
	   	       List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class, 'select-color')]"));
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
	   	    	//validatingInstock.inStockValidation();

	   	       }else if(sizeElements.size()>0&&colorElement.size()>0) {
	   	    	   
	   	    	//selecting the color   
	   	    	attributesSelection.colorSelection();
	   	    	Thread.sleep(3000);
	   	    	//select the size
	   	    	attributesSelection.sizeSelction();
	   	    	Thread.sleep(3000);
	   	    	Thread.sleep(5000);
	   	    	//validate the product is instock or not
	   	    	//validatingInstock.inStockValidation();
	   	    	   
	   	       }
	   	       
		     }
		     //selecting the memory size of the product
	        }else if(countofmemorysize.size()>0) {
	        	Thread.sleep(3000);
	        	 List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class, 'select-color')]"));
		   	     System.out.println("colorElement: "+colorElement.size());
	        	
	        	if(colorElement.size()>0) {
		          	//selcting the color   
		   	    	attributesSelection.colorSelection();
		   	    	Thread.sleep(3000);
		   	    	attributesSelection.memorySelection();
		   	    	//Thread.sleep(3000);
		   	    	Thread.sleep(5000);
	        	}else {
	        	   	attributesSelection.memorySelection();
		   	    	//Thread.sleep(3000);
		   	    	Thread.sleep(5000);
	        	}

	   	 
	   	    	//validate the product is instock or not
	   	    	//validatingInstock.inStockValidation();
	        	//logger.info("memory size");

	        }else if(countofAccesSizeElement.size()>0){
	        	
	          	//selcting the color   
	   	    	attributesSelection.colorSelection();
	   	    	Thread.sleep(3000);
	        	//size of acc
	        	attributesSelection.AccsizeSelction();
	        	
	   	    	//validate the product is instock or not
	   	    	//validatingInstock.inStockValidation();
	        }else {

	   	    	//validate the product is instock or not
	   	    	//validatingInstock.inStockValidation();
	        }
	        Thread.sleep(3000);

	   }
            
}

