package com.test.etsy.pages;

import com.test.etsy.tests.EtsyBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomepage extends EtsyBase {
    public EtsyHomepage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#global-enhancements-search-query")
    WebElement searchInput;

    @FindBy (xpath = "//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    WebElement searchButton;

    public void searchFunction(String searchKeyword) throws InterruptedException {
        Thread.sleep(1000);
        searchInput.sendKeys(searchKeyword);
        Thread.sleep(1000);
        searchButton.click();
    }
}
