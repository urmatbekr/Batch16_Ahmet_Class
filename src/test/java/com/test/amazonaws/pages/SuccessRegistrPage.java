package com.test.amazonaws.pages;

import com.test.amazonaws.tests.AmazonawsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessRegistrPage extends AmazonawsBase {

    public SuccessRegistrPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy (xpath = "//input[@name='password']")
    WebElement password;

    @FindBy (xpath = "//button[@name='loginbtn']")
    WebElement loginButton;

    public void loginFunction(String username, String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);
    }

}
