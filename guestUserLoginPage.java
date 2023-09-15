//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guestUserLoginPage {
    WebDriver lDriver;
    @FindBy(
        xpath = "//input[@id='email']"
    )
    WebElement guestmail;
    @FindBy(
        xpath = "//input[@id='password']"
    )
    WebElement guestPassword;
    @FindBy(
        xpath = "//button[contains(text(),'Guest Checkout')]"
    )
    WebElement guestCheckOut;
    @FindBy(
        xpath = "//input[@id='email-guest']"
    )
    WebElement reEnterMailInGuest;
    @FindBy(
        xpath = "//button[contains(text(),' Continue as guest')]"
    )
    WebElement continueAsGuest;

    public guestUserLoginPage(WebDriver rDriver) {
        this.lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    public void clickOnGuestMail(String mail) throws InterruptedException {
        this.guestmail.sendKeys(new CharSequence[]{mail});
        Thread.sleep(2000L);
    }

    public void clickOnGuestPassword(String password) throws InterruptedException {
        this.guestPassword.sendKeys(new CharSequence[]{password});
        Thread.sleep(2000L);
    }

    public void clickOnGuestCheckOut() {
        this.guestCheckOut.click();
    }

    public void clickOnEmail(String reEnterMail) {
        this.reEnterMailInGuest.sendKeys(new CharSequence[]{reEnterMail});
    }

    public void clickOnContinueAsGuest() {
        this.continueAsGuest.click();
    }
}
