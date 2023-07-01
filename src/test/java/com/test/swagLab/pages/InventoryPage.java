package com.test.swagLab.pages;

import Utils.BrowserUtils;
import com.test.swagLab.tests.SwagLabBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class InventoryPage extends SwagLabBase {
    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> productNames;

    @FindBy (xpath = "//div[@class='inventory_details_name large_size']")
    WebElement ProductNameLarge;

    @FindBy (xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement ProductDescription;

    @FindBy (xpath = "//div[@class='inventory_details_price']")
    WebElement price;

    public void productCart(String expectedProduct, String expectedDescription, String expectedPrice) {
        for (WebElement cardName: productNames){
            if (BrowserUtils.getText(cardName).equals(expectedProduct)){
                cardName.click();
                break;
            }
        }
        Assert.assertEquals(ProductNameLarge.getText(),expectedProduct);
        Assert.assertEquals(ProductDescription.getText(), expectedDescription);
        Assert.assertEquals(price.getText(),expectedPrice);
    }

}
