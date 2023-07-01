package com.test.amazonaws.pages;

import Utils.BrowserUtils;
import com.test.amazonaws.tests.AmazonawsBase;
import com.test.amazonaws.tests.AmazonawsHomePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AmazonawsHomePage extends AmazonawsBase {
    public AmazonawsHomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (partialLinkText = "//a[@class='nav-link']")
    List <WebElement> navList;

    public void checkingLoginFunction(String username){
        for (WebElement login: navList){
            Assert.assertEquals(BrowserUtils.getText(login),username);
        }
    }

}
