package com.test.blaze.tests;

import Utils.ConfigReader;
import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {

    @Test(dataProvider = "orderData", dataProviderClass = BlazeData.class)
    public void validateCartInfo(String category, String brand, String price, String expected, String expectedMessage, String Name, String lastName,
                                 String country, String city, String month, String year) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        homePage.findFromCategories(category);
        ProductPage productPage = new ProductPage(driver);
        productPage.findMacbookPro(driver, brand);
        macBookProPage.textMacBookPro(brand, expectedMessage,
                "Product description\n" +
                        "The Nokia Lumia 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 processor and it comes with 2GB of RAM.");
        Thread.sleep(500);
        macBookProPage.addAndAlert(driver, expected);
        homePage.cartClick();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartInfoChecking(brand, price);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.purchaseOrderFunctions(driver, Name, lastName, country, city, month, year);
    }

    @Parameters({"laptop", "macbookType", "price", "description", "description2", "ProductAdded", "name", "lastName", "city", "card", "month", "year"})
    @Test
    public void validateCartInfo(String laptop, String macbookType, String price, String description,
                                 String description2, String ProductAdded, String name, String lastName,
                                 String city, String card, String month, String year)
            throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        homePage.findFromCategories(laptop);
        ProductPage productPage = new ProductPage(driver);
        productPage.findMacbookPro(driver, macbookType);

        macBookProPage.textMacBookPro(macbookType, price,
                description + "\n" + description2);
        macBookProPage.addAndAlert(driver, ProductAdded);
        homePage.cartClick();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartInfoChecking(ConfigReader.redProperty("QA_Blaze_Laptop_Brand"),
                ConfigReader.redProperty("QA_Blaze_Laptop_Price"));
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.purchaseOrderFunctions(driver, name, lastName, city, card, month, year);

    }
}
