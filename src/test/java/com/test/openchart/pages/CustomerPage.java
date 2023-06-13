package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {
    public CustomerPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement closeButton;

    @FindBy (css = "#menu-customer")
    WebElement customerMenu;

    @FindBy (xpath = "//li[@id='menu-customer']//li[1]")
    WebElement linkCustomers;

    @FindBy (xpath = "//a[@aria-label='Add New']")
    WebElement addCustomerButton;

    @FindBy (css = "#input-firstname")
    WebElement firstName;

    @FindBy (css = "#input-lastname")
    WebElement lastName;

    @FindBy (css = "#input-email")
    WebElement email;

    @FindBy (css = "#input-password")
    WebElement password;

    @FindBy (css = "#input-confirm")
    WebElement passwordConfirm;

    @FindBy (css = "#input-newsletter")
    WebElement newsletter;

    @FindBy (css = "#input-safe")
    WebElement safe;

    @FindBy (xpath = "//i[@class ='fas fa-save']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement alertMessage;


    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String email,String password, String passwordConfirm) throws InterruptedException {
        closeButton.click();
        customerMenu.click();
        Thread.sleep(1000);
        linkCustomers.click();
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        Thread.sleep(500);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(passwordConfirm);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",newsletter);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,newsletter);
        BrowserUtils.clickWithJS(driver,safe);
        BrowserUtils.clickWithJS(driver,saveButton);
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(alertMessage), "Warning: You do not have permission to modify customers!");
    }

}
