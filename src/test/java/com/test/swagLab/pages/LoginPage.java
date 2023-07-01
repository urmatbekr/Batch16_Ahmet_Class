package com.test.swagLab.pages;

import com.test.swagLab.tests.SwagLabBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends SwagLabBase {
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#user-name")
    WebElement loginInput;

    @FindBy (css = "#password")
    WebElement passwordInput;

    @FindBy (css = "#login-button")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class='error-message-container error']")
    WebElement errorText;

    public void loginFunctionality(String login, String password) throws InterruptedException {
        Thread.sleep(500);
        loginInput.sendKeys(login);
        Thread.sleep(500);
        passwordInput.sendKeys(password);
        Thread.sleep(500);
        loginButton.click();
        Thread.sleep(1000);
    }

    public void getErrorText(String expected){
        Assert.assertEquals(errorText.getText(),expected);
    }

}
