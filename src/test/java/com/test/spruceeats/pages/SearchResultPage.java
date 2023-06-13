package com.test.spruceeats.pages;

import Utils.BrowserUtils;
import com.test.spruceeats.tests.SpruceEatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultPage extends SpruceEatsTestBase {
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStarButton;

   @FindBy (xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoiceButton;

   @FindBy (xpath = "//h4//span")
   WebElement foodName;

   public void searchingRoasterSalmon(String expectedName) throws InterruptedException {
       Thread.sleep(2000);
       if (!fourStarButton.isSelected() && fourStarButton.isEnabled()) {
           fourStarButton.click();
       }
       Thread.sleep(2000);
       editorChoiceButton.click();
       Thread.sleep(1000);
       Assert.assertEquals(BrowserUtils.getText(foodName), expectedName);
       Thread.sleep(500);

   }





}
