package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase{
    @Test
    public void validateCartInfo() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        homePage.findFromCategories("Laptops");
        ProductPage productPage = new ProductPage(driver);
        productPage.findMacbookPro(driver, "MacBook Pro");

        macBookProPage.textMacBookPro("MacBook Pro", "$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.addAndAlert(driver,"Product added");
        homePage.cartClick();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartInfoChecking("MacBook Pro", "1100");
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.purchaseOrderFunctions(driver, "Ahmet", "Baldir", "Istanbul", "42343232", "12", "2023");

    }
}
