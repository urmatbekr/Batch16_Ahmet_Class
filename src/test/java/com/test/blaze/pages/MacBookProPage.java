package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.test.blaze.tests.BlazeTestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage extends BlazeTestBase {

    public MacBookProPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h2[@class='name']")
    WebElement laptopName;

    @FindBy (xpath = "//h3[@class='price-container']")
    WebElement laptopPrice;

    @FindBy (xpath = "//div[@id='more-information']")
    WebElement laptopInfo;

    @FindBy (xpath = "//a[contains(@onclick,'addToCart')]")
    WebElement addButton;

    public void textMacBookPro (String brandName, String productPrice, String productInfo) throws InterruptedException {

        Assert.assertEquals(BrowserUtils.getText(laptopName), brandName);
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(laptopPrice), productPrice);
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(laptopInfo), productInfo);
        Thread.sleep(500);

    }

    public void addAndAlert (WebDriver driver ,String alertText) throws InterruptedException {
        addButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), alertText);
        Thread.sleep(1000);
        alert.accept();
    }


}
