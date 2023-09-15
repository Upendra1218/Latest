package com.providio.validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class menusValidation extends baseClass{

	public static void allMenusValidation() {
		List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
        List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
        List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
        List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

        if(newArrivalplp.size()>0) {
        	
        	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that NewArrivals of  " + pageTitleText + " ");
        	if (pageTitleText.equals(newArrivalsCategory[-1])) {
        		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                logger.info("click Success NewArrivals of  " + pageTitleText + "");
            }
        	
        }else if(womensplp.size()>0) {
        	
        	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Womens of  " + pageTitleText + " ");
        	if (pageTitleText.equals(womensCategory[-1])) {
        		test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                logger.info("click Success Womens of  " + pageTitleText + "");
            }
        }else if(menplp.size()>0) {
        	
        	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Mens of  " + pageTitleText + " ");
        	if (pageTitleText.equals(mensCategory[-1])) {
        		test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                logger.info("click Success Mens of  " + pageTitleText + "");
        	}
        }else {

        	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Electronics of  " + pageTitleText + " ");
        	if (pageTitleText.equals(electronicsCategory[-1])) {
        		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                logger.info("click Success Electronics of  " + pageTitleText + "");
        	}
        }
	}
}
