package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkOutPage {
WebDriver lDriver;
	
	public checkOutPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//shippingMethods
	@FindBy(xpath = "(//span[contains(text(),'Ground')])[1]")
	WebElement GroundElement;
	
	//shipping method for express
	@FindBy(xpath = "(//span[contains(text(),'Express')])[1]")
	WebElement ExpressElement;
	
	//usps
	@FindBy(xpath = "(//span[contains(text(),'Ground')])[1]")
	WebElement USPS_Element;
	
	
	public void clickOnGround() throws InterruptedException{
		Thread.sleep(1000);
		GroundElement.click();
	}
	

	public void clickOnExpress() throws InterruptedException{
		Thread.sleep(1000);
		ExpressElement.click();
	}
	

	public void clickOnUSPS() throws InterruptedException{
		Thread.sleep(1000);
		USPS_Element.click();
	}
	
	//ShippingDetails
	//FirstName
	@FindBy(xpath="//input[@id='shippingFirstNamedefault']")
	WebElement FirstName;
	public void setFisrtName(String fname ){		
		FirstName.sendKeys(fname);
        
	}

	//LastName
	@FindBy(xpath="//input[@id='shippingLastNamedefault']")
	WebElement LastName;
	public void setLastname(String lname ){
		LastName.sendKeys(lname);
	}
	//Address1
	@FindBy(xpath="//input[@id='shippingAddressOnedefault']")
	WebElement Address1;
	public void setAddress1(String address ){
		Address1.sendKeys(address);
	}
	
	//city
	@FindBy(xpath="//input[@id ='shippingAddressCitydefault']")
	WebElement city;
	public void setcity(String cityname ){
		city.sendKeys(cityname);
	}	
	//Country
	@FindBy(xpath="//select[@id='shippingCountrydefault']")
	WebElement Country;
	public void setCountry() throws InterruptedException{
		 Select countrySelect = new Select(Country);
	        countrySelect.selectByIndex(1);
	        Thread.sleep(1000);
	}
	
	//Province
	@FindBy(xpath="//select[@id='shippingStatedefault']")
	WebElement Province;
	public void setProvince(){
		Select ProvinceSelect = new Select(Province);
        ProvinceSelect.selectByIndex(3);
	}
	
	//zipCode
	@FindBy(xpath="//input[@id='shippingZipCodedefault']")
	WebElement zipCode;
	public void setzipCode(String zipcode){	
		zipCode.sendKeys(zipcode);
	}
	
	//Phone
	@FindBy(xpath="//input[@id='shippingPhoneNumberdefault']")
	WebElement Phone;
	public void setPhone(String phonenumber ){
		 Phone.sendKeys(phonenumber);
	}
	
	//buttonforthepaymentpage
	@FindBy(xpath ="//button[contains(text(), 'Next: Payment')]")
	WebElement paymentbutton;
    public void clickpaymentbutton(WebDriver driver) throws InterruptedException {
    	
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", paymentbutton);
        Thread.sleep(5000);
    }
    
    //add to my address
    
    @FindBy(xpath = "(//input[@id='addShippingAddressToMyAccount'])[1]")
    
	WebElement addToMyAddress;
    public void clickaddToMyAddress(WebDriver driver) throws InterruptedException {
    	
    	addToMyAddress.click();
    	
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", addToMyAddress);
        Thread.sleep(5000);
    }
    
    
    

    
    
    
    

}
