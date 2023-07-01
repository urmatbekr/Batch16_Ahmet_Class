package com.test.amazonaws.pages;

import com.test.amazonaws.tests.AmazonawsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AmazonawsBase {
    public RegisterPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy (xpath = "//input[@name='password']")
    WebElement password;

    @FindBy (xpath = "//button[@name='loginbtn']")
    WebElement registerButton;

    public void RegisterFunction(String userName, String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        registerButton.click();
        Thread.sleep(3000);
    }
}
