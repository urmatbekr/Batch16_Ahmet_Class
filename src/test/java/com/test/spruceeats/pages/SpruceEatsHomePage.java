package com.test.spruceeats.pages;

import Utils.BrowserUtils;
import com.test.spruceeats.tests.SpruceEatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class SpruceEatsHomePage extends SpruceEatsTestBase {

    public SpruceEatsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='global-nav__list-item-link']//span[contains(text(),'Ingredients')]")
    WebElement ingredientsButton;

    @FindBy(xpath = "//li[@class='global-nav__sub-list-item']//a[@class='global-nav__sub-list-item-link']")
    List<WebElement> allOptions;

    public void selectFishAndSeaFood(WebDriver driver, String typeFood) throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(ingredientsButton).perform();
        Thread.sleep(2000);
        for (int i = 0; i < allOptions.size(); i++) {
            Thread.sleep(500);
            if (BrowserUtils.getText(allOptions.get(i)).equals(typeFood.toUpperCase())) {
                Thread.sleep(500);
                actions.click(allOptions.get(i)).perform();
            }
        }
    }
}
