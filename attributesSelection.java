package com.providio.commonfunctionality;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

public class attributesSelection extends baseClass{
	
	public static void sizeSelction() {
		
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-size')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }
	
	//color selection
	
	public static void colorSelection() {

		WebElement widthElement = driver.findElement(By.xpath("//select[contains(@class, 'select-color')]"));
		test.info("Verify that color select");
	    Select colorSelect = new Select(widthElement);
	    List<WebElement> options1 = colorSelect.getOptions();
	    List<String> enabledSizes1 = new ArrayList<>();
	    int optionIndex1 = 0;
	    for (WebElement option : options1) {
	    	if (optionIndex1 > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes1.add(value);
	                //System.out.println(value);
	                option.click();
	                logger.info("Selected the color");
	                test.pass("Successfully selected the color");
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }
	    	else {
	    		//System.out.println("This size is not avaliable");
	    	}
	    	
	    	 optionIndex1++;
	    }
	}
	
	//selecting the width elements
	public static void widthSelection() throws InterruptedException {
		test.info("Verify that width select");
		
		WebElement widthElement = driver.findElement(By.xpath("//select[contains(@class, 'select-width')]"));
		
		
		Select widthSelect = new Select(widthElement);
		
		// Get the list of available options
	  List<WebElement> availableOptionsofwidth = widthSelect.getOptions();
	
	  // Create a list to store the indices of enabled options
	  List<Integer> enabledIndixes = new ArrayList<>();
	
	  // Iterate through the available options and store the indices of enabled options
	  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
	  	
	      if (availableOptionsofwidth.get(a).isEnabled()) {
	      	enabledIndixes.add(a);
	      }
	  }
	  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
	  //logger.info(enabledIndixes);
	  System.out.println("total numbers of"+enabledIndixes);

	  System.out.println("only width"+enabledIndixes);
	  // Select the option at the random index
	  widthSelect.selectByIndex(randomIndexofwidth);
	  logger.info("Selected the width");
	  
	  test.pass("Successfully selected the width");
	
	  Thread.sleep(3000);

	}
	
	public static void memorySelection() {
		test.info("Verify that memory size select");
		WebElement memoryElement = driver.findElement(By.xpath("//select[contains(@class, 'select-memorySize')]"));
      
	    Select colorSelect = new Select(memoryElement);
	    List<WebElement> options1 = colorSelect.getOptions();
	    List<String> enabledSizes1 = new ArrayList<>();
	    int optionIndex1 = 0;
	    for (WebElement option : options1) {
	    	if (optionIndex1 > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes1.add(value);
	                //System.out.println(value);
	                option.click();
	                logger.info("Selected the memory size");
	                test.pass("Successfully selected the memeory size");
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }
	    	else {
	    		//System.out.println("This size is not avaliable");
	    	}
	    	
	    	 optionIndex1++;
	    }
	}
	
   public static void AccsizeSelction() {
		
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }
	

}
