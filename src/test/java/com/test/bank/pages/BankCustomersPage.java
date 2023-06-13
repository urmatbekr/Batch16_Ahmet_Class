package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankCustomersPage {
    public BankCustomersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#userSelect")
    WebElement customerNameList;

    @FindBy (xpath = "//button[@type]")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeText;


    public void selectCustomerFunctionality(String customerName){
        BrowserUtils.selectBy(customerNameList, customerName, "text");
        loginButton.click();
        BrowserUtils.getText(welcomeText);

    }

    @FindBy (xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy (xpath = "//button[contains(text(),'amount')]")
    WebElement amount;




}
