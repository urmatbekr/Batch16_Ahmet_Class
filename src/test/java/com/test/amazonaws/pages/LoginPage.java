package com.test.amazonaws.pages;

import com.test.amazonaws.tests.AmazonawsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AmazonawsBase {
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy (xpath = "//input[@name='password']")
    WebElement password;

    @FindBy (xpath = "//button[@name='regbtn']")
    WebElement registerButton;

    @FindBy (xpath = "//button[@name='loginbtn']")
    WebElement loginButton;

    public void clearInput() throws InterruptedException {
        userName.clear();
        password.clear();
        Thread.sleep(1000);
    }

    public void registerbutton() throws InterruptedException {
        registerButton.click();
        Thread.sleep(1500);
    }



}
