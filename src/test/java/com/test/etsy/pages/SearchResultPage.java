package com.test.etsy.pages;

import Utils.BrowserUtils;
import com.test.etsy.tests.EtsyBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends EtsyBase {
    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a//div/h3")
    List<WebElement> productTitles;

    public void checkingName(String keyword1, String keyword2, String keyword3) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 2; i < productTitles.size(); i++) {
            String text = productTitles.get(i).getText().toUpperCase();
            Assert.assertTrue(text.contains(keyword1.toUpperCase()) ||
                    text.contains(keyword2.toUpperCase()) ||
                    text.contains(keyword3.toUpperCase()));
        }
    }


}
