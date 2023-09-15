package com.providio.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class navigationPage extends baseClass{

WebDriver lDriver;
public navigationPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

       //Menunewarrivals
		@FindBy(xpath="//a[@id = 'newarrivals']")
		WebElement newarrivalsMenu;
		public void clicknewarrivalssMenu(WebDriver driver) throws InterruptedException{
			
			Actions action = new Actions(driver);
	    	action.moveToElement(newarrivalsMenu).perform();
	    	Thread.sleep(5000);
		}
		//submensNewarrivals
		//womens
		@FindBy(xpath="//a[@id='newarrivals-womens']")
		WebElement newarrivalWomens;
		public void ClicknewarrivalofWomens(){
			newarrivalWomens.click();
		}
		//mens
		@FindBy(xpath="//a[@id='newarrivals-mens']")
		WebElement newarrivalsMens;
		public void ClicknewarrivalofMens(){
			newarrivalsMens.click();
		}
		//electronics
		@FindBy(xpath="//a[@id='newarrivals-electronics']")
		WebElement newarrivalElectronics;
		public void ClicknewarrivalofElectronics(){
			newarrivalElectronics.click();
		}
		
			
		//MenuWomens
		@FindBy(xpath="//a[@id = 'womens']")
		WebElement WomensMenu;
		public void clickwoMensMenubaritems(WebDriver driver) throws InterruptedException{
			
			Actions action = new Actions(driver);
	    	action.moveToElement(WomensMenu).perform();
	    	Thread.sleep(5000);
		}
		//submensWomens
		//outfilts
		@FindBy(xpath="//a[@id='womens-outfits']")
		WebElement womensOutfits;
		public void ClickwoMensofOutfits(){
			womensOutfits.click();
		}
		//clothing
		@FindBy(xpath="//a[@id='womens-clothing']")
		WebElement womensclothing;
		public void ClickwoMensofclothing(){
			womensclothing.click();
		}
		//jewelry  
		@FindBy(xpath="//a[@id='womens-jewelry']")
		WebElement womensjewelry;
		public void ClickwoMensofjewelry(){
			womensjewelry.click();
		}
		@FindBy(xpath="//a[@id='womens-accessories']")
		WebElement womensaccessories;
		public void ClickwoMensofaccessories(){
			womensaccessories.click();
		}
		//accessories
		//tops
		@FindBy(xpath="//a[@id='womens-clothing-tops']")
		WebElement womenstops;
		public void ClickwoMensofTops(){
			womenstops.click();
		}
		//dresses
		@FindBy(xpath="//a[@id='womens-clothing-dresses']")
		WebElement womenDresses;
		public void ClickwoMensofDresses(){
			womenDresses.click();
		}

		//womenjackets
		@FindBy(xpath="//a[@id='womens-clothing-jackets']")
		WebElement womensJackets;
		public void ClickwoMensofjackets(){
			womensJackets.click();
		}
		//red
		@FindBy(xpath="//a[@id='womens-clothing-feeling-red']")
		WebElement womensfeelingred;
		public void ClickwoMensofFeelingRed(){
			womensfeelingred.click();
		}
		//Earrings
		@FindBy(xpath="//a[@id='womens-jewelry-earrings']")
		WebElement womenEarrings;
		public void ClickwoMensofEarRings(){
			womenEarrings.click();
		}
		//Bracelets
		@FindBy(xpath="//a[@id='womens-jewelry-bracelets']")
		WebElement womenBracelets;
		public void ClickwoMensofBraceletss(){
			womenBracelets.click();
		}
		//necklaces
		@FindBy(xpath="//a[@id='womens-jewelry-necklaces']")
		WebElement womennecklaces;
		public void ClickwoMensofnecklaces(){
			womennecklaces.click();
		}
		//scarves
		@FindBy(xpath="//a[@id='womens-accessories-scarves']")
		WebElement womensscarves;
		public void ClickwoMensofscarves(){
			womensscarves.click();
		}
		//shoes
		@FindBy(xpath="//a[@id='womens-accessories-shoes']")
		WebElement womensshoes;
		public void ClickwoMensofshoes(){
			womensshoes.click();
		}
		//bottoms
		@FindBy(xpath="//a[@id='womens-clothing-bottoms']")
		WebElement womenbottoms;
		public void ClickwoMensofbottoms(){
			womenbottoms.click();
		}
		
        //menuMens
		@FindBy(xpath="//a[@id = 'mens']")
		WebElement Mensmenu;
		public void clickMensMenubaritems(WebDriver driver) throws InterruptedException{			
			Actions action = new Actions(driver);
	    	action.moveToElement(Mensmenu).perform();
	    	Thread.sleep(5000);
		}
	   //submenusMens
		//clothing
		@FindBy(xpath="//a[@id='mens-clothing']")
		WebElement Mensclothing;
		public void ClickMensofclothing(){
			Mensclothing.click();
		}
		//accessories
		@FindBy(xpath="//a[@id='mens-accessories']")
		WebElement Mensaccessories;
		public void ClickMensofaccessories(){
			Mensaccessories.click();
		}
		//suits
		@FindBy(xpath="//a[@id='mens-clothing-suits']")
		WebElement MensSuits;
		public void ClickMensofsuits(){
			MensSuits.click();
		}
		//jackets
		@FindBy(xpath="//a[@id='mens-clothing-jackets']")
		WebElement Mensjackets;
		public void ClickMensofJackets(){
			Mensjackets.click();
		}
		//dressShirts
		@FindBy(xpath="//a[@id='mens-clothing-dress-shirts']")
		WebElement MensShirts;
		public void ClickMensofShirts(){
			MensShirts.click();
		}
		//Shorts
		//dressShirts
		@FindBy(xpath="//a[@id='mens-clothing-shorts']")
		WebElement MensShorts;
		public void ClickMensofShorts(){
			MensShorts.click();
		}
		//pants
		//dressShirts
		@FindBy(xpath="//a[@id='mens-clothing-pants']")
		WebElement MensPants;
		public void ClickMensofPants() throws InterruptedException{
			Thread.sleep(1000);
			MensPants.click();
		}
		//ties
		@FindBy(xpath="//a[@id='mens-accessories-ties']")
		WebElement Mensties;
		public void ClickMensofties(){
			Mensties.click();
		}
		
		//gloves
		@FindBy(xpath="//a[@id='mens-accessories-gloves']")
		WebElement Mensgloves;
		public void ClickMensofgloves(){
			Mensgloves.click();
		}
		//luggage
		@FindBy(xpath="//a[@id='mens-accessories-luggage']")
		WebElement Mensluggage;
		public void ClickMensofluggage(){
			Mensluggage.click();
		}
		
		
		
		//Menuelectronics
		@FindBy(xpath="//a[@id = 'electronics']")
		WebElement electronicsMenu;
		public void clickelectronicsMenu(WebDriver driver) throws InterruptedException{
			
			Actions action = new Actions(driver);
	    	action.moveToElement(electronicsMenu).perform();
	    	Thread.sleep(5000);
		}
		//submenselectronics
		//televisions
		@FindBy(xpath="//a[@id='electronics-televisions']")
		WebElement electronicsTelevisions;
		public void ClickelectronicsofTelevisions(WebDriver driver) throws InterruptedException{
			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", electronicsTelevisions);
//			Thread.sleep(2000);
//			electronicsTelevisions.click();
		}
		//cameras
		@FindBy(xpath="//a[@id='electronics-digital-cameras']")
		WebElement electronicsdigitalcameras;
		public void Clickelectronicsofcameras(){
			electronicsdigitalcameras.click();
		}
		//media-players
		@FindBy(xpath="//a[@id='electronics-digital-media-players']")
		WebElement electronicsmediaplayers;
		public void Clickelectronicsofmediaplayers(){
			electronicsmediaplayers.click();
		}
		//gps-units
		@FindBy(xpath="//a[@id='electronics-gps-units']")
		WebElement electronicsGpsUnits;
		public void ClickelectronicsofGpsUnits(){
			electronicsGpsUnits.click();
		}
		//gaming
		@FindBy(xpath="//a[@id='electronics-gaming']")
		WebElement electronicsgaming;
		public void ClickelectronicsofGaming(){
			electronicsgaming.click();
		}
		
		
		//MenuTopseller
		@FindBy(xpath="//a[@id = 'top-seller']")
		WebElement Topseller;
		public void clickTopsellerMenu(WebDriver driver) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Topseller);
	    	Thread.sleep(5000);
	    	//Topseller.click();
		}
		
		public void selectRandomMenu(WebDriver driver) throws InterruptedException {
			
	        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = elements.size();
	        Random random = new Random();
	        int randomNumbermenu = random.nextInt(count) + 1;
	        
	        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
	        int countdropdown = elementsofdrop.size();
	        int randomNumberitem = random.nextInt(countdropdown) + 1;
	        WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
	        Thread.sleep(5000L);
	        Actions action = new Actions(driver);
	        action.moveToElement(NavigationRandomMenu).perform();
	        Thread.sleep(5000L);
	        WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	        Thread.sleep(5000L);
	        
	        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
            List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
            List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
            List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

            if(newArrivalplp.size()>0) {
            	
            	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
            	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
            	String pageTitleText = pageTitle.getText();
            	test.info("verify that NewArrivals of  " + pageTitleText + " ");
            	if (pageTitleText.equals(newArrivalsCategory[randomNumberitem-1])) {
            		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                    logger.info("click Success NewArrivals of  " + pageTitleText + "");
                }
            	
            }else if(womensplp.size()>0) {
            	
            	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
            	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
            	String pageTitleText = pageTitle.getText();
            	test.info("verify that Womens of  " + pageTitleText + " ");
            	if (pageTitleText.equals(womensCategory[randomNumberitem-1])) {
            		test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                    logger.info("click Success Womens of  " + pageTitleText + "");
                }
            }else if(menplp.size()>0) {
            	
            	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
            	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
            	String pageTitleText = pageTitle.getText();
            	test.info("verify that Mens of  " + pageTitleText + " ");
            	if (pageTitleText.equals(mensCategory[randomNumberitem-1])) {
            		test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                    logger.info("click Success Mens of  " + pageTitleText + "");
            	}
            }else {

            	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
            	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
            	String pageTitleText = pageTitle.getText();
            	test.info("verify that Electronics of  " + pageTitleText + " ");
            	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
            		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                    logger.info("click Success Electronics of  " + pageTitleText + "");
            	}
            }

	    }

	    public void goingThroughAlltheMenus(WebDriver driver) throws InterruptedException {
	        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();
	        //System.out.println(count);
	       // Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            //System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            //int randomNumbermenuitem = random.nextInt(countdropdown);
	            //System.out.println(countdropdown);
	            
	           // System.out.println(randomNumbermenuitem);

	            for(int j = 1; j <= countdropdown; ++j) {
	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                //String menuname = NavigationMenu.getText();
	                //System.out.println(menuname);
	                
	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                //System.out.println("Menu name " + menuname);
	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));
	                //String submenuName = NavigationMenuitem.getText();
	                //System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	                Thread.sleep(5000L);
	                List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
	                List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
	                List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
	                List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

	                
	                if(newArrivalplp.size()>0) {
	                	//System.out.println("New");
	                	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
	                	//System.out.println(newArrivalsCategory[j-1]);
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	//System.out.println(pageTitleText);
	                	if (pageTitleText.equals(newArrivalsCategory[j-1])) {
	                		System.out.println("NewArrival of "+pageTitleText);
	                    }
	                	
	                }else if(womensplp.size()>0) {
	                	//System.out.println("womens");
	                	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
	                	//System.out.println(womensCategory[j-1]);
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	//System.out.println(pageTitleText);
	                	if (pageTitleText.equals(womensCategory[j-1])) {
	                		System.out.println("Womens of "+pageTitleText);
	                    }
	                }else if(menplp.size()>0) {
	                	//System.out.println("mens");
	                	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
	                	//System.out.println(mensCategory[j-1]);
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	//System.out.println(pageTitleText);
	                	if (pageTitleText.equals(mensCategory[j-1])) {
	                		System.out.println("Mens of "+pageTitleText);
	                	}
	                }else {
	                	//System.out.println("electronics");
	                	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
	                	//System.out.println(electronicsCategory[j-1]);
	                	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	                	String pageTitleText = pageTitle.getText();
	                	//System.out.println(pageTitleText);
	                	if (pageTitleText.equals(electronicsCategory[j-1])) {
	                		System.out.println("Electronics of "+pageTitleText);
	                	}
	                }
	                
	                //System.out.println("Sub menu name  " + submenuName);
	            }
	        }
	    }
	        
	        public void goingThroughEachMenuOneItem(WebDriver driver) throws InterruptedException {
		        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
		        int count = countofMenus.size();
		        System.out.println(count);
		        Random random = new Random();

		        for(int i = 1; i <= count; ++i) {
		            System.out.println("Menu of number" + i);
		            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
		            int countdropdown = noelementsofdrop.size();
		            int randomNumbermenuitem = random.nextInt(countdropdown);
		            System.out.println(countdropdown);
		            
		            System.out.println(randomNumbermenuitem);

		                Thread.sleep(5000);
		                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
		                String menuname = NavigationMenu.getText();
		                System.out.println(menuname);
		                
		                Thread.sleep(5000);
		                Actions action = new Actions(driver);
		                action.moveToElement(NavigationMenu).perform();
		                Thread.sleep(5000L);
		                
		                System.out.println("Menu name " + menuname);
		                
		                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
		                String submenuName = NavigationMenuitem.getText();
		                System.out.println("Menu name " + submenuName);
		                JavascriptExecutor js = (JavascriptExecutor)driver;
		                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
		                Thread.sleep(5000L);
		                
		                System.out.println("Sub menu name  " + submenuName);
		            }
		        }

		
	    
}
