package com.test.spruceeats.pages;

import Utils.BrowserUtils;
import com.test.spruceeats.tests.SpruceEatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeaFoodPage extends SpruceEatsTestBase {
    public SeaFoodPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search-form-input']")
    WebElement searchRecipe;

    @FindBy (css = "#button_1-0")
    WebElement searchButton;


    public void searchFunction(WebDriver driver, String foodName) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(100,300);
        BrowserUtils.scrollWithJS(driver,searchRecipe);
        Thread.sleep(1000);
        searchRecipe.sendKeys(foodName);
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, searchButton);
    }
}
