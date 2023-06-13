package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this); //it does the same logic of driver.findElement

    }

    @FindBy (css = ".mainHeading")
    WebElement header;

    @FindBy (xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy (xpath = "//button[contains(text(),'Bank Manager')]")
    WebElement managerLogin;

    public void LoginPageComponentsValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed() && managerLogin.isEnabled());
    }

    public void clickManagerButton(){
        managerLogin.click();
    }

    @FindBy (xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeText;

    @FindBy (css = "#userSelect")
    WebElement customerNameList;

    public void selectCustomerFunctionality(String customerName){
        BrowserUtils.selectBy(customerNameList, customerName, "text");
        customerLogin.click();
        BrowserUtils.getText(welcomeText);

    }


}
