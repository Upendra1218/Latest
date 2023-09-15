package com.providio.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.allAttributesinOneFile;


public class tc__NavigationEachMenuOneItemGuestUser extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

    @Test
    public void Navigation() throws InterruptedException {

    	test.info("Open browser");
        // Test Case 0: Open browser
        driver.get(baseURL);
        logger.info("Opened browser");
      
        	
            test.info("Test case for the Navigationmenu of Newarrival Page");
            
            List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();

	        Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            int randomNumbermenuitem = random.nextInt(countdropdown)+1;
	            logger.info(randomNumbermenuitem);

	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                //String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);

	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();",NavigationMenuitem);
	                Thread.sleep(5000L);
	                
	                List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
	                List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
	                List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
	                //List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

	                if(newArrivalplp.size()>0) {
	                	
	                	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	test.info("verify that NewArrivals of  " + pageTitleText + " ");
	                	if (pageTitleText.equals(newArrivalsCategory[randomNumbermenuitem-1])) {
	                		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
	                        logger.info("click Success NewArrivals of  " + pageTitleText + "");
	                    }
	                	
	                }else if(womensplp.size()>0) {
	                	
	                	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	test.info("verify that Womens of  " + pageTitleText + " ");
	                	if (pageTitleText.equals(womensCategory[randomNumbermenuitem-1])) {
	                		test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
	                        logger.info("click Success Womens of  " + pageTitleText + "");
	                    }
	                }else if(menplp.size()>0) {
	                	
	                	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	test.info("verify that Mens of  " + pageTitleText + " ");
	                	if (pageTitleText.equals(mensCategory[randomNumbermenuitem-1])) {
	                		test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
	                        logger.info("click Success Mens of  " + pageTitleText + "");
	                	}
	                }else {

	                	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	test.info("verify that Electronics of  " + pageTitleText + " ");
	                	if (pageTitleText.equals(electronicsCategory[randomNumbermenuitem-1])) {
	                		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
	                        logger.info("click Success Electronics of  " + pageTitleText + "");
	                	}
	                }
	                
	                
	                List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));	    	        
	    	        int totalProductcount = products.size();	    	        
	    	        int randomselectProduct = random.nextInt(totalProductcount) + 1;

	    	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])"+"  "+"[" + randomselectProduct + "]"));
	    	       // String productName = RandomSelectProductFormPLP.getText();
	    	        //logger.info(productName);
	    	        js.executeScript("arguments[0].click();",  RandomSelectProductFormPLP);
	    	        
	    	        //logger.info(productName);
	    	        

	    	        Thread.sleep(3000);
	    	        
	    	        //selecting attributes
	    	        
	    	        allAttributesinOneFile.allAttributes();  
	        } 
	         
	        
	        //checkoutProcess
	        
            tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();
            
            cp.checkoutprocess();
            
            //payment process
            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
            
            cc.paymentByCreditCard();           


        // Assert all the soft assertions
        softAssert.assertAll();

  

    }
 }
