package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class LoginPage {

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#input-username")
    WebElement userNameInput;

    @FindBy (css = "#input-password")
    WebElement userPasswordInput;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy (css = "#alert")
    WebElement errorMessage;

    public void validateLoginFunctionality (String userName, String password) throws InterruptedException {
        userNameInput.sendKeys(userName);
        userPasswordInput.sendKeys(password);
        loginButton.click();
        Thread.sleep(2000);
    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
