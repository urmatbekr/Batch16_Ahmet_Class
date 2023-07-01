package com.test.swagLab.tests;

import Utils.BrowserUtils;
import com.test.blaze.tests.BlazeData;
import com.test.swagLab.pages.InventoryPage;
import com.test.swagLab.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SwagLabBase {

    @Test(priority = 1, dataProvider = "successLogin", dataProviderClass = LoginData.class)
    public void validateLoginFunction(String login, String password,
                                      String expectedMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(login, password);
        Assert.assertEquals(driver.getCurrentUrl(), expectedMessage);

    }

    @Test(priority = 2, dataProvider = "negative", dataProviderClass = LoginData.class)
    public void validateNegativeLoginFunction(String login, String password,
                                              String expectedMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(login, password);
        loginPage.getErrorText(expectedMessage);
    }

//    @Test(priority = 3, dataProvider = "validateCart", dataProviderClass = LoginData.class)
//    public void validateProductCart(String login, String password,
//                                      String expectedMessage, String expectedProduct,
//                                    String expectedDescription, String expectedPrice) throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginFunctionality(login, password);
//        Assert.assertEquals(driver.getCurrentUrl(), expectedMessage);
//        InventoryPage inventoryPage = new InventoryPage(driver);
//        inventoryPage.productCart( expectedProduct,  expectedDescription,  expectedPrice);
//
//    }
}
