package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#name")
    WebElement nameInput;

    @FindBy (css = "#country")
    WebElement countryInput;

    @FindBy (css = "#city")
    WebElement cityInput;

    @FindBy (css = "#card")
    WebElement cardInput;

    @FindBy (css = "#month")
    WebElement monthInput;

    @FindBy (css = "#year")
    WebElement yearInput;

    @FindBy (xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;

    @FindBy (xpath = "//h2[contains(text(),'Thank you')]")
    WebElement thankyouText;

    @FindBy (xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement okButton;

    public void purchaseOrderFunctions(WebDriver driver, String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        nameInput.sendKeys(name);
        countryInput.sendKeys(country);
        cityInput.sendKeys(city);
        Thread.sleep(1000);
        cardInput.sendKeys(creditCard);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(thankyouText.getText(),"Thank you for your purchase!");
        okButton.click();
        Thread.sleep(2000);
        String actual = driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(actual, "https://www.demoblaze.com/index.html");
    }


}
